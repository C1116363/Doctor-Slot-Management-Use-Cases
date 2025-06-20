package com.doctor.slotmanagement.Controller;


import com.doctor.slotmanagement.Entity.SlotTemplate;
import com.doctor.slotmanagement.service.SlotTemplateService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/slot-templates")
public class SlotTemplateController {

    private final SlotTemplateService templateService;

    public SlotTemplateController(SlotTemplateService templateService) {
        this.templateService = templateService;
    }

    // ✅ Save a new slot template
    @PostMapping
    public ResponseEntity<SlotTemplate> saveTemplate(@RequestBody SlotTemplate template) {
        SlotTemplate saved = templateService.save(template);
        return ResponseEntity.ok(saved);
    }

    // ✅ Generate slots using templates for a date range
    @PostMapping("/generate")
    public ResponseEntity<String> generateSlotsFromTemplate(
            @RequestParam Long doctorId,
            @RequestParam Long clinicId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        templateService.generate(doctorId, clinicId, startDate, endDate);
        return ResponseEntity.ok("Slots generated successfully.");
    }
}

