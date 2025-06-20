package com.doctor.slotmanagement.repository;



import com.doctor.slotmanagement.Entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}

