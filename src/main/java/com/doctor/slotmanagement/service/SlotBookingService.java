package com.doctor.slotmanagement.service;



import com.doctor.slotmanagement.Entity.Slot;
import com.doctor.slotmanagement.enums.SlotStatus;
import com.doctor.slotmanagement.repository.SlotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SlotBookingService {
    private final SlotRepository slotRepo;
    public SlotBookingService(SlotRepository slotRepo) { this.slotRepo = slotRepo; }

    @Transactional
    public String lock(Long slotId) {
        Slot s = slotRepo.findById(slotId).orElseThrow();
        s.unlockIfExpired();
        if (s.isLocked() || s.getStatus() != SlotStatus.AVAILABLE) {
            throw new RuntimeException("Not available");
        }
        s.lockSlot();
        slotRepo.save(s);
        return "Locked";
    }

    @Transactional
    public String confirm(Long slotId) {
        Slot s = slotRepo.findById(slotId).orElseThrow();
        if (s.getStatus() != SlotStatus.PENDING || !s.isLocked()) {
            throw new RuntimeException("Cannot confirm");
        }
        s.setStatus(SlotStatus.BOOKED);
        s.setBookedAt(java.time.LocalDateTime.now());
        slotRepo.save(s);
        return "Booked";
    }

    @Transactional
    public int releaseExpired() {
        List<Slot> list = slotRepo.findByStatus(SlotStatus.PENDING);
        int count = 0;
        for (Slot s : list) {
            if (!s.isLocked()) {
                s.setStatus(SlotStatus.AVAILABLE);
                s.setLockedAt(null);
                slotRepo.save(s);
                count++;
            }
        }
        return count;
    }
}
