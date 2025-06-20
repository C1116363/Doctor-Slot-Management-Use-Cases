package com.doctor.slotmanagement.service;



import com.doctor.slotmanagement.Entity.Slot;
import com.doctor.slotmanagement.repository.SlotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SlotService {
    private final SlotRepository slotRepo;
    public SlotService(SlotRepository slotRepo) { this.slotRepo = slotRepo; }

    public Slot create(Slot s) {
        return slotRepo.save(s);
    }

    public List<Slot> getAll() {
        return slotRepo.findAll();
    }

    @Transactional
    public int bulkUpdateDuration(Long doctorId, int newMinutes) {
        // Construct and perform bulk logic based on your DB and JPA query support
        return 0;
    }

    @Transactional
    public int bulkDeleteRange(Long doctorId, String timeRange) {
        return slotRepo.bulkDeleteByRange(doctorId, timeRange);
    }
}

