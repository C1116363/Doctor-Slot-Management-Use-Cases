package com.doctor.slotmanagement.Controller;



import com.doctor.slotmanagement.Entity.WalkInQueueEntry;
import com.doctor.slotmanagement.service.WalkInQueueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/walkin")
public class WalkInQueueController {

    private final WalkInQueueService queueService;

    public WalkInQueueController(WalkInQueueService queueService) {
        this.queueService = queueService;
    }

    // ✅ Join a walk-in queue
    @PostMapping("/join")
    public ResponseEntity<WalkInQueueEntry> joinQueue(
            @RequestParam Long slotId,
            @RequestParam String name,
            @RequestParam String mobile
    ) {
        WalkInQueueEntry entry = queueService.join(slotId, name, mobile);
        return ResponseEntity.ok(entry);
    }

    // ✅ Get current walk-in queue for a slot
    @GetMapping("/queue")
    public ResponseEntity<List<WalkInQueueEntry>> getQueue(@RequestParam Long slotId) {
        List<WalkInQueueEntry> queue = queueService.queue(slotId);
        return ResponseEntity.ok(queue);
    }
}

