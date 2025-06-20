package com.doctor.slotmanagement.config;



import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class BookingRulesConfig {

    // Maximum number of appointments a doctor can take per day
    private int maxAppointmentsPerDay = 10;

    // Minimum time gap between two appointments (in minutes)
    private int minGapBetweenAppointments = 5;

    // Maximum number of days in advance a patient can book
    private int maxAdvanceBookingDays = 30;

    // Cutoff time for same-day bookings
    private LocalTime sameDayBookingCutoffTime = LocalTime.of(16, 0); // 4:00 PM

    public int getMaxAppointmentsPerDay() {
        return maxAppointmentsPerDay;
    }

    public void setMaxAppointmentsPerDay(int maxAppointmentsPerDay) {
        this.maxAppointmentsPerDay = maxAppointmentsPerDay;
    }

    public int getMinGapBetweenAppointments() {
        return minGapBetweenAppointments;
    }

    public void setMinGapBetweenAppointments(int minGapBetweenAppointments) {
        this.minGapBetweenAppointments = minGapBetweenAppointments;
    }

    public int getMaxAdvanceBookingDays() {
        return maxAdvanceBookingDays;
    }

    public void setMaxAdvanceBookingDays(int maxAdvanceBookingDays) {
        this.maxAdvanceBookingDays = maxAdvanceBookingDays;
    }

    public LocalTime getSameDayBookingCutoffTime() {
        return sameDayBookingCutoffTime;
    }

    public void setSameDayBookingCutoffTime(LocalTime sameDayBookingCutoffTime) {
        this.sameDayBookingCutoffTime = sameDayBookingCutoffTime;
    }
}

