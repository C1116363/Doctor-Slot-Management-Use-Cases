package com.doctor.slotmanagement.Controller;


import com.doctor.slotmanagement.Entity.Slot;
import com.doctor.slotmanagement.service.SlotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    // ✅ Create a new slot
    @PostMapping
    public ResponseEntity<Slot> createSlot(@RequestBody Slot slot) {
        Slot createdSlot = slotService.create(slot);
        return ResponseEntity.ok(createdSlot);
    }

    // ✅ Get all slots
    @GetMapping
    public ResponseEntity<List<Slot>> getAllSlots() {
        List<Slot> slots = slotService.getAll();
        return ResponseEntity.ok(slots);
    }

    // ✅ Bulk delete by time range (doctorId + range)
    @DeleteMapping("/bulk-delete")
    public ResponseEntity<String> bulkDeleteSlots(
            @RequestParam Long doctorId,
            @RequestParam String timeRange) {
        int deleted = slotService.bulkDeleteRange(doctorId, timeRange);
        return ResponseEntity.ok(deleted + " slot(s) deleted.");
    }

    // ✅ Bulk update duration (Future enhancement – currently placeholder)
    @PutMapping("/bulk-update-duration")
    public ResponseEntity<String> bulkUpdateDuration(
            @RequestParam Long doctorId,
            @RequestParam int newMinutes) {
        int updated = slotService.bulkUpdateDuration(doctorId, newMinutes);
        return ResponseEntity.ok(updated + " slot(s) updated with new duration.");
    }
}

