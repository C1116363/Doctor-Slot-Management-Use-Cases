package com.doctor.slotmanagement.Entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "slot_handover_logs")
public class SlotHandoverLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long slotId;
    private Long fromDoctorId;
    private Long toDoctorId;
    private String reason;
    private LocalDateTime handoverTime;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public Long getFromDoctorId() {
        return fromDoctorId;
    }

    public void setFromDoctorId(Long fromDoctorId) {
        this.fromDoctorId = fromDoctorId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getToDoctorId() {
        return toDoctorId;
    }

    public void setToDoctorId(Long toDoctorId) {
        this.toDoctorId = toDoctorId;
    }

    public LocalDateTime getHandoverTime() {
        return handoverTime;
    }

    public void setHandoverTime(LocalDateTime handoverTime) {
        this.handoverTime = handoverTime;
    }
}

