package com.doctor.slotmanagement.repository;


import com.doctor.slotmanagement.Entity.DoctorUnavailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnavailabilityRepository extends JpaRepository<DoctorUnavailability, Long> {
    List<DoctorUnavailability> findByDoctorId(Long doctorId);
}

