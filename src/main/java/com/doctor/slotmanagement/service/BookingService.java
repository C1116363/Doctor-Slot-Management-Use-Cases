package com.doctor.slotmanagement.service;

import com.doctor.slotmanagement.config.BookingRulesConfig;
import com.doctor.slotmanagement.Entity.Slot;
import com.doctor.slotmanagement.enums.SlotStatus;
import com.doctor.slotmanagement.repository.SlotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookingService {

    private final SlotRepository slotRepo;
    private final BookingRulesConfig rules;

    public BookingService(SlotRepository r, BookingRulesConfig c) {
        this.slotRepo = r;
        this.rules = c;
    }

    @Transactional
    public String book(Long patientId, Long slotId) {
        Slot s = slotRepo.findById(slotId).orElseThrow();
        checkRules(s, patientId);
        s.setPatientId(patientId);
        s.setStatus(SlotStatus.BOOKED);
        s.setBookedAt(LocalDateTime.now());
        slotRepo.save(s);
        return "Booked";
    }

    private void checkRules(Slot s, Long patientId) {
        // Use custom formatter that matches "2025-06-21 10:00:00"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Extract start time from tsrange string like "[2025-06-21 10:00:00,2025-06-21 10:30:00)"
        String startStr = s.getTimeRange().split(",")[0].replace("[", "").trim();
        LocalDateTime start = LocalDateTime.parse(startStr, formatter);
        LocalDate date = start.toLocalDate();

        // 1. Limit per doctor
        long c = slotRepo.countByDoctorIdAndDate(s.getPrimaryDoctorId(), date);
        if (c >= rules.getMaxAppointmentsPerDay()) {
            throw new RuntimeException("Limit reached");
        }

        // 2. Advance booking days
        if (start.isAfter(LocalDateTime.now().plusDays(rules.getMaxAdvanceBookingDays()))) {
            throw new RuntimeException("Too far ahead");
        }

        // 3. Same-day booking cutoff
        if (date.equals(LocalDate.now()) && LocalTime.now().isAfter(rules.getSameDayBookingCutoffTime())) {
            throw new RuntimeException("Too late for today");
        }

        // 4. Patient appointment gap rule
        List<Slot> list = slotRepo.findAllByPatientIdAndDate(patientId, date);
        for (Slot o : list) {
            String oStartStr = o.getTimeRange().split(",")[0].replace("[", "").trim();
            LocalDateTime st = LocalDateTime.parse(oStartStr, formatter);
            if (Math.abs(Duration.between(st, start).toMinutes()) < rules.getMinGapBetweenAppointments()) {
                throw new RuntimeException("Need more gap");
            }
        }
    }
}
