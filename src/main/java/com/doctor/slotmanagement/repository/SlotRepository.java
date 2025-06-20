package com.doctor.slotmanagement.repository;

import com.doctor.slotmanagement.Entity.Slot;
import com.doctor.slotmanagement.enums.SlotStatus;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

    List<Slot> findByPrimaryDoctorIdAndClinicId(Long doctorId, Long clinicId);

    List<Slot> findByPrimaryDoctorIdAndStatus(Long doctorId, SlotStatus status);

    // ✅ Check overlapping slots (tsrange needs to be constructed)
    @Query(value = "SELECT * FROM slots s WHERE s.primary_doctor_id = ?1 AND CAST(s.time_range AS tsrange) && tsrange(?2, ?3)", nativeQuery = true)
    List<Slot> findSlotsOverlapping(Long doctorId, String startTime, String endTime);

    // ✅ Corrected: count by date with proper casting
    @Query(value = "SELECT COUNT(*) FROM slots s WHERE s.primary_doctor_id = ?1 AND DATE(lower(CAST(s.time_range AS tsrange))) = ?2", nativeQuery = true)
    int countSlotsByDoctorAndDate(Long doctorId, LocalDate date);
    @Query(value = "SELECT COUNT(*) FROM slots s WHERE s.primary_doctor_id = ?1 AND DATE(lower(CAST(s.time_range AS tsrange))) = ?2", nativeQuery = true)
    long countByDoctorIdAndDate(Long doctorId, LocalDate date);


    List<Slot> findByStatus(SlotStatus status);

    // ✅ Bulk delete with proper casting
    @Modifying
    @Query(value = "DELETE FROM slots WHERE primary_doctor_id = :doctorId AND CAST(time_range AS tsrange) && CAST(:timeRange AS tsrange)", nativeQuery = true)
    int bulkDeleteByRange(@Param("doctorId") Long doctorId, @Param("timeRange") String timeRange);

    // ✅ Cancel slots in overlapping range with casting
    @Modifying
    @Query(value = """
        UPDATE slots 
        SET status = 'CANCELLED' 
        WHERE primary_doctor_id = :doctorId 
        AND CAST(time_range AS tsrange) && CAST(:timeRange AS tsrange)
        """, nativeQuery = true)
    int cancelSlotsInRange(@Param("doctorId") Long doctorId, @Param("timeRange") String timeRange);

    // ✅ Patient appointment gap rule check
    @Query(value = """
        SELECT * FROM slots 
        WHERE patient_id = :patientId 
        AND DATE(lower(CAST(time_range AS tsrange))) = :date
        """, nativeQuery = true)
    List<Slot> findAllByPatientIdAndDate(@Param("patientId") Long patientId, @Param("date") LocalDate date);

    // ✅ Available slots within range with proper casting
    @Query(value = """
        SELECT * FROM slots 
        WHERE primary_doctor_id = :doctorId 
          AND clinic_id = :clinicId 
          AND status = 'AVAILABLE' 
          AND CAST(time_range AS tsrange) && CAST(:range AS tsrange)
        ORDER BY lower(CAST(time_range AS tsrange))
        LIMIT :limit
        """, nativeQuery = true)
    List<Slot> findAvailableSlots(
            @Param("doctorId") Long doctorId,
            @Param("clinicId") Long clinicId,
            @Param("range") String range,
            @Param("limit") int limit
    );

    // ✅ Find slots by patient
    List<Slot> findSlotsByPatientId(Long patientId);

    // ✅ Total bookings by patient
    @Query("SELECT COUNT(s) FROM Slot s WHERE s.patientId = :patientId")
    long totalBookings(@Param("patientId") Long patientId);
}
