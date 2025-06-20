package com.doctor.slotmanagement.dto;


public class SlotBookingDTO {

    private Long patientId;
    private Long slotId;

    // Optional: patient name, reason, etc.

    // Getters and Setters

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }
}

