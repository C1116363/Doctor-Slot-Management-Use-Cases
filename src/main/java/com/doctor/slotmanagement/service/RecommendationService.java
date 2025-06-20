package com.doctor.slotmanagement.service;


import com.doctor.slotmanagement.Entity.Slot;
import com.doctor.slotmanagement.repository.SlotRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class RecommendationService {
    private final SlotRepository slotRepo;
    public RecommendationService(SlotRepository r) { this.slotRepo = r; }

    public List<Slot> recommend(Long doctorId, Long clinicId, LocalDate date, int limit) {
        String range = "[" + date + " 00:00," + date.plusDays(1) + " 00:00)";
        return slotRepo.findAvailableSlots(doctorId, clinicId, range, limit);
    }

}

