package com.doctor.slotmanagement.Entity;



import com.doctor.slotmanagement.enums.SlotStatus;
import com.doctor.slotmanagement.enums.SlotType;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "slots",
        uniqueConstraints = @UniqueConstraint(columnNames = {"primary_doctor_id", "time_range"}))
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primary_doctor_id")
    private Long primaryDoctorId;

    @Column(name = "delegate_doctor_id")
    private Long delegateDoctorId;

    @Column(name = "patient_id")
    private Long patientId;

    private boolean attended;

    @Column(name = "clinic_id")
    private Long clinicId;

    @Column(name = "time_range")
    private String timeRange;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SlotStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "slot_type")
    private SlotType slotType;

    private String tag;
    private String notes;
    private String colorCode;

    @Column(name = "locked_at")
    private LocalDateTime lockedAt;

    @Column(name = "booked_at")
    private LocalDateTime bookedAt;

    @Column(name = "attended_at")
    private LocalDateTime attendedAt;

    @Version
    private Integer version;

    // Slot Lock Logic
    public boolean isLocked() {
        if (lockedAt == null || status != SlotStatus.PENDING) {
            return false;
        }
        Duration duration = Duration.between(lockedAt, LocalDateTime.now());
        return duration.toMinutes() < 5;
    }

    public void lockSlot() {
        this.status = SlotStatus.PENDING;
        this.lockedAt = LocalDateTime.now();
    }

    public void unlockIfExpired() {
        if (this.status == SlotStatus.PENDING && !isLocked()) {
            this.status = SlotStatus.AVAILABLE;
            this.lockedAt = null;
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrimaryDoctorId() {
        return primaryDoctorId;
    }

    public void setPrimaryDoctorId(Long primaryDoctorId) {
        this.primaryDoctorId = primaryDoctorId;
    }

    public Long getDelegateDoctorId() {
        return delegateDoctorId;
    }

    public void setDelegateDoctorId(Long delegateDoctorId) {
        this.delegateDoctorId = delegateDoctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public LocalDateTime getLockedAt() {
        return lockedAt;
    }

    public void setLockedAt(LocalDateTime lockedAt) {
        this.lockedAt = lockedAt;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(LocalDateTime bookedAt) {
        this.bookedAt = bookedAt;
    }

    public LocalDateTime getAttendedAt() {
        return attendedAt;
    }

    public void setAttendedAt(LocalDateTime attendedAt) {
        this.attendedAt = attendedAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}


