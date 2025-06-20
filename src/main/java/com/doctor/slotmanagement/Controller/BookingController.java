package com.doctor.slotmanagement.Controller;


import com.doctor.slotmanagement.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService service) {
        this.bookingService = service;
    }

    // ✅ Book a slot
    @PostMapping
    public ResponseEntity<String> bookSlot(
            @RequestParam Long patientId,
            @RequestParam Long slotId
    ) {
        String result = bookingService.book(patientId, slotId);
        return ResponseEntity.ok(result);
    }
}

