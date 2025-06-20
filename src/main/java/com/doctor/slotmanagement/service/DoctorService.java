package com.doctor.slotmanagement.service;



import com.doctor.slotmanagement.Entity.Doctor;
import com.doctor.slotmanagement.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepo;
    public DoctorService(DoctorRepository doctorRepo) { this.doctorRepo = doctorRepo; }

    public Doctor create(Doctor d) { return doctorRepo.save(d); }
    public Doctor get(Long id) { return doctorRepo.findById(id).orElse(null); }
    public List<Doctor> getAll() { return doctorRepo.findAll(); }
}

