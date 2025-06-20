package com.doctor.slotmanagement.service;


import com.doctor.slotmanagement.Entity.WalkInQueueEntry;
import com.doctor.slotmanagement.repository.WalkInQueueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalkInQueueService {
    private final WalkInQueueRepository repo;
    public WalkInQueueService(WalkInQueueRepository r) { this.repo = r; }

    public WalkInQueueEntry join(Long slotId, String name, String mobile) {
        WalkInQueueEntry e = new WalkInQueueEntry();
        e.setSlotId(slotId);
        e.setPatientName(name);
        e.setMobile(mobile);
        e.setAttended(false);
        e.setJoinedAt(java.time.LocalDateTime.now());
        return repo.save(e);
    }

    public List<WalkInQueueEntry> queue(Long slotId) {
        return repo.findBySlotIdOrderByJoinedAtAsc(slotId);
    }
}

