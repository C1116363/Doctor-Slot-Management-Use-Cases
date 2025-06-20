package com.doctor.slotmanagement.Controller;


import com.doctor.slotmanagement.Entity.Slot;
import com.doctor.slotmanagement.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    // ✅ Recommend available slots
    @GetMapping
    public ResponseEntity<List<Slot>> getRecommendedSlots(
            @RequestParam Long doctorId,
            @RequestParam Long clinicId,
            @RequestParam String date,     // e.g., 2025-06-22
            @RequestParam int limit
    ) {
        LocalDate parsedDate = LocalDate.parse(date);
        List<Slot> slots = recommendationService.recommend(doctorId, clinicId, parsedDate, limit);
        return ResponseEntity.ok(slots);
    }
}

