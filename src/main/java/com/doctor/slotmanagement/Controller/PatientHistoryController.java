package com.doctor.slotmanagement.Controller;


import com.doctor.slotmanagement.dto.PatientSlotHistory;
import com.doctor.slotmanagement.service.PatientHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientHistoryController {

    private final PatientHistoryService historyService;

    public PatientHistoryController(PatientHistoryService historyService) {
        this.historyService = historyService;
    }

    // ✅ Get patient's slot history
    @GetMapping("/{patientId}/history")
    public ResponseEntity<List<PatientSlotHistory>> getSlotHistory(@PathVariable Long patientId) {
        List<PatientSlotHistory> history = historyService.history(patientId);
        return ResponseEntity.ok(history);
    }

    // ✅ Get total bookings
    @GetMapping("/{patientId}/total")
    public ResponseEntity<String> getTotalBookings(@PathVariable Long patientId) {
        String result = historyService.check(patientId);
        return ResponseEntity.ok(result);
    }
}

