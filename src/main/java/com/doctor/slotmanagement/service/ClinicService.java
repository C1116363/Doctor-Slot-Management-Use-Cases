package com.doctor.slotmanagement.service;


import com.doctor.slotmanagement.Entity.Clinic;
import com.doctor.slotmanagement.repository.ClinicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;

    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public Clinic createClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    public Clinic getClinicById(Long id) {
        return clinicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clinic not found with ID: " + id));
    }
}

