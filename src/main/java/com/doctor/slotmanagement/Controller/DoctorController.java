package com.doctor.slotmanagement.Controller;


import com.doctor.slotmanagement.Entity.Doctor;
import com.doctor.slotmanagement.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // ✅ Create a new doctor
    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.create(doctor);
        return ResponseEntity.ok(createdDoctor);
    }

    // ✅ Get a doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long id) {
        Doctor doctor = doctorService.get(id);
        if (doctor != null) {
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Get all doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAll();
        return ResponseEntity.ok(doctors);
    }

    // ✅ Get doctors by clinic name
    @GetMapping("/by-clinic")
    public ResponseEntity<List<Doctor>> getDoctorsByClinicName(@RequestParam String clinicName) {
        List<Doctor> doctors = doctorService
                .getAll()
                .stream()
                .filter(d -> d.getClinicName().equalsIgnoreCase(clinicName))
                .toList();
        return ResponseEntity.ok(doctors);
    }
}

