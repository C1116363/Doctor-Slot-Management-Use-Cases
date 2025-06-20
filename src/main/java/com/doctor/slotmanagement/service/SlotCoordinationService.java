package com.doctor.slotmanagement.service;



import com.doctor.slotmanagement.Entity.Slot;
import com.doctor.slotmanagement.Entity.SlotHandoverLog;
import com.doctor.slotmanagement.repository.SlotHandoverRepository;
import com.doctor.slotmanagement.repository.SlotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SlotCoordinationService {
    private final SlotRepository repo;
    private final SlotHandoverRepository handoverRepo;
    public SlotCoordinationService(SlotRepository r, SlotHandoverRepository h) {
        this.repo = r; this.handoverRepo = h;
    }

    @Transactional
    public String delegate(Long slotId, Long newDoc, String reason) {
        Slot s = repo.findById(slotId).orElseThrow();
        Long old = s.getPrimaryDoctorId();
        s.setDelegateDoctorId(newDoc);
        repo.save(s);
        SlotHandoverLog log = new SlotHandoverLog();
        log.setSlotId(slotId);
        log.setFromDoctorId(old);
        log.setToDoctorId(newDoc);
        log.setReason(reason);
        log.setHandoverTime(java.time.LocalDateTime.now());
        handoverRepo.save(log);
        return "Delegated";
    }
}

