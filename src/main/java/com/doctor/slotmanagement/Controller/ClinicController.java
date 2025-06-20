package com.doctor.slotmanagement.Controller;


import com.doctor.slotmanagement.Entity.Clinic;
import com.doctor.slotmanagement.service.ClinicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
public class ClinicController {

    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    // ✅ Create a new clinic
    @PostMapping
    public ResponseEntity<Clinic> createClinic(@RequestBody Clinic clinic) {
        Clinic created = clinicService.createClinic(clinic);
        return ResponseEntity.ok(created);
    }

    // ✅ Get all clinics
    @GetMapping
    public ResponseEntity<List<Clinic>> getAllClinics() {
        return ResponseEntity.ok(clinicService.getAllClinics());
    }

    // ✅ Get clinic by ID
    @GetMapping("/{id}")
    public ResponseEntity<Clinic> getClinicById(@PathVariable Long id) {
        return ResponseEntity.ok(clinicService.getClinicById(id));
    }
}

