package com.doctor.slotmanagement.Entity;



import com.doctor.slotmanagement.enums.UnavailabilityType;
import jakarta.persistence.*;

@Entity
@Table(name = "doctor_unavailability")
public class DoctorUnavailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "time_range")
    private String timeRange;

    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UnavailabilityType type;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
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

