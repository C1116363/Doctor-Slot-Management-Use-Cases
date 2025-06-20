package com.doctor.slotmanagement.service;


import com.doctor.slotmanagement.Entity.Patient;
import com.doctor.slotmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getById(Long id) {
        return patientRepository.findById(id);
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient update(Long id, Patient updatedPatient) {
        return patientRepository.findById(id).map(existingPatient -> {
            existingPatient.setName(updatedPatient.getName());
            existingPatient.setEmail(updatedPatient.getEmail());
            existingPatient.setPhone(updatedPatient.getPhone());
            existingPatient.setDateOfBirth(updatedPatient.getDateOfBirth());
            existingPatient.setVip(updatedPatient.isVip());
            existingPatient.setMissedAppointmentsCount(updatedPatient.getMissedAppointmentsCount());
            return patientRepository.save(existingPatient);
        }).orElse(null);
    }
}

