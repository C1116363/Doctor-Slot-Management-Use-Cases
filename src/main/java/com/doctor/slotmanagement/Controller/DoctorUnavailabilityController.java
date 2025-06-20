package com.doctor.slotmanagement.Controller;



import com.doctor.slotmanagement.Entity.DoctorUnavailability;
import com.doctor.slotmanagement.service.DoctorUnavailabilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/unavailability")
public class DoctorUnavailabilityController {

    private final DoctorUnavailabilityService service;

    public DoctorUnavailabilityController(DoctorUnavailabilityService service) {
        this.service = service;
    }

    // ✅ Mark a doctor as unavailable
    @PostMapping
    public ResponseEntity<DoctorUnavailability> markUnavailability(@RequestBody DoctorUnavailability unavailability) {
        DoctorUnavailability result = service.mark(unavailability);
        return ResponseEntity.ok(result);
    }
}

