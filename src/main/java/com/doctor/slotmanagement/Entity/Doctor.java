package com.doctor.slotmanagement.Entity;
import com.doctor.slotmanagement.enums.DoctorType;
import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;

    @Enumerated(EnumType.STRING)
    private DoctorType type;

    private String clinicName;
    private String branchLocation;

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }

    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public DoctorType getType() { return type; }

    public void setType(DoctorType type) { this.type = type; }

    public String getClinicName() { return clinicName; }

    public void setClinicName(String clinicName) { this.clinicName = clinicName; }

    public String getBranchLocation() { return branchLocation; }

    public void setBranchLocation(String branchLocation) { this.branchLocation = branchLocation; }
}

