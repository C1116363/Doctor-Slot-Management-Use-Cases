package com.doctor.slotmanagement.repository;


import com.doctor.slotmanagement.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByClinicName(String clinicName);

}

