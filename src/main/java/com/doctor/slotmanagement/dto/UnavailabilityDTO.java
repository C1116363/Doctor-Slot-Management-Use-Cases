package com.doctor.slotmanagement.dto;



import com.doctor.slotmanagement.enums.UnavailabilityType;

public class UnavailabilityDTO {

    private Long doctorId;
    private String startTime;  // ISO
    private String endTime;
    private String reason;
    private UnavailabilityType type;

    // Getters and Setters

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public UnavailabilityType getType() {
        return type;
    }

    public void setType(UnavailabilityType type) {
        this.type = type;
    }
}

