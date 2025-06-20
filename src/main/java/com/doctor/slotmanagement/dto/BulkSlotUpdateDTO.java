package com.doctor.slotmanagement.dto;

public class BulkSlotUpdateDTO {

    private Long doctorId;
    private String startDate;
    private String endDate;
    private int newDurationInMinutes;

    // Getters and Setters

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getNewDurationInMinutes() {
        return newDurationInMinutes;
    }

    public void setNewDurationInMinutes(int newDurationInMinutes) {
        this.newDurationInMinutes = newDurationInMinutes;
    }
}

