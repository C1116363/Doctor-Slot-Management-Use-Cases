package com.doctor.slotmanagement.repository;



import com.doctor.slotmanagement.Entity.SlotHandoverLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotHandoverRepository extends JpaRepository<SlotHandoverLog, Long> {
}

