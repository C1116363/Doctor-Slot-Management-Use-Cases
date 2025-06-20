package com.doctor.slotmanagement.repository;


import com.doctor.slotmanagement.Entity.WalkInQueueEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalkInQueueRepository extends JpaRepository<WalkInQueueEntry, Long> {
    List<WalkInQueueEntry> findBySlotIdOrderByJoinedAtAsc(Long slotId);
}

