package com.doctor.slotmanagement.service;

import com.doctor.slotmanagement.Entity.DoctorUnavailability;
import com.doctor.slotmanagement.repository.UnavailabilityRepository;
import com.doctor.slotmanagement.repository.SlotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorUnavailabilityService {

    @Autowired
    private UnavailabilityRepository unavailRepo;

    @Autowired
    private SlotRepository slotRepository;

    @Transactional
    public DoctorUnavailability mark(DoctorUnavailability u) {
        DoctorUnavailability saved = unavailRepo.save(u);
        slotRepository.cancelSlotsInRange(u.getDoctorId(), u.getTimeRange());
        return saved;
    }
}

