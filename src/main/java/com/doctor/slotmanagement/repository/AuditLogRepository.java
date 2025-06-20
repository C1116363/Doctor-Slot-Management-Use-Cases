package com.doctor.slotmanagement.repository;



import com.doctor.slotmanagement.Entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}

