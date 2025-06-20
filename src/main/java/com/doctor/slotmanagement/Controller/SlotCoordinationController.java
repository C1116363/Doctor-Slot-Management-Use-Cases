package com.doctor.slotmanagement.Controller;


import com.doctor.slotmanagement.service.SlotCoordinationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/slot-coordination")
public class SlotCoordinationController {

    private final SlotCoordinationService coordinationService;

    public SlotCoordinationController(SlotCoordinationService coordinationService) {
        this.coordinationService = coordinationService;
    }

    // ✅ Delegate a slot from one doctor to another
    @PostMapping("/delegate")
    public ResponseEntity<String> delegateSlot(
            @RequestParam Long slotId,
            @RequestParam Long newDoctorId,
            @RequestParam String reason
    ) {
        String result = coordinationService.delegate(slotId, newDoctorId, reason);
        return ResponseEntity.ok(result);
    }
}

