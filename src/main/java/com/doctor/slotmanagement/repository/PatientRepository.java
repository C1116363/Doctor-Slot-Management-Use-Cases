package com.doctor.slotmanagement.repository;



import com.doctor.slotmanagement.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

