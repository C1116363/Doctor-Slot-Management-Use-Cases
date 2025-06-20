package com.doctor.slotmanagement.dto;


public class PatientSlotHistory {
    private Long slotId;
    private String timeRange;
    private boolean attended;
    private String status;

    // Constructor
    public PatientSlotHistory(Long slotId, String timeRange, boolean attended, String status) {
        this.slotId = slotId;
        this.timeRange = timeRange;
        this.attended = attended;
        this.status = status;
    }

    // Getters and Setters
    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
