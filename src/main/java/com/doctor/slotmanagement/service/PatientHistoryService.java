package com.doctor.slotmanagement.service;


import com.doctor.slotmanagement.dto.PatientSlotHistory;
import com.doctor.slotmanagement.Entity.Slot;
import com.doctor.slotmanagement.repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientHistoryService {
    private final SlotRepository repo;

    public PatientHistoryService(SlotRepository repo) {
        this.repo = repo;
    }

    public List<PatientSlotHistory> history(Long patientId) {
        List<Slot> slots = repo.findSlotsByPatientId(patientId);
        List<PatientSlotHistory> out = new ArrayList<>();
        for (Slot s : slots) {
            PatientSlotHistory ph = new PatientSlotHistory(
                    s.getId(),
                    s.getTimeRange(),
                    s.isAttended(),
                    s.getStatus().name()
            );
            out.add(ph);
        }
        return out;
    }

    public String check(Long patientId) {
        long total = repo.totalBookings(patientId);
        return "Total bookings: " + total;
    }
}
