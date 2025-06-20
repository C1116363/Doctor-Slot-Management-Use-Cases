package com.doctor.slotmanagement.repository;



import com.doctor.slotmanagement.Entity.SlotTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotTemplateRepository extends JpaRepository<SlotTemplate, Long> {
    List<SlotTemplate> findByDoctorId(Long doctorId);
}

