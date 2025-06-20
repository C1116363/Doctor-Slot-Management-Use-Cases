package com.doctor.slotmanagement.service;


import com.doctor.slotmanagement.Entity.Slot;
import com.doctor.slotmanagement.Entity.SlotTemplate;
import com.doctor.slotmanagement.repository.SlotRepository;
import com.doctor.slotmanagement.repository.SlotTemplateRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class SlotTemplateService {
    private final SlotTemplateRepository templateRepo;
    private final SlotRepository slotRepo;
    public SlotTemplateService(SlotTemplateRepository templateRepo, SlotRepository slotRepo) {
        this.templateRepo = templateRepo; this.slotRepo = slotRepo;
    }

    public SlotTemplate save(SlotTemplate t) { return templateRepo.save(t); }

    public void generate(Long doctorId, Long clinicId, LocalDate start, LocalDate end) {
        List<SlotTemplate> list = templateRepo.findByDoctorId(doctorId);
        LocalDate cursor = start;
        while (!cursor.isAfter(end)) {
            for (SlotTemplate t : list) {
                if (t.getDayOfWeek().equalsIgnoreCase(cursor.getDayOfWeek().name())) {
                    LocalTime cur = LocalTime.parse(t.getStartTime());
                    LocalTime endSlot = LocalTime.parse(t.getEndTime());
                    while (cur.plusMinutes(t.getDurationMinutes()).compareTo(endSlot) <= 0) {
                        Slot s = new Slot();
                        s.setPrimaryDoctorId(doctorId);
                        s.setClinicId(clinicId);
                        s.setTimeRange(
                                "[" + cursor + " " + cur + "," + cursor + " " + cur.plusMinutes(t.getDurationMinutes()) + ")"
                        );
                        s.setSlotType(t.getSlotType());
                        s.setStatus(com.doctor.slotmanagement.enums.SlotStatus.AVAILABLE);
                        s.setTag(t.getTemplateName());
                        s.setColorCode(t.getColorCode());
                        slotRepo.save(s);
                        cur = cur.plusMinutes(t.getDurationMinutes());
                    }
                }
            }
            cursor = cursor.plusDays(1);
        }
    }
}

