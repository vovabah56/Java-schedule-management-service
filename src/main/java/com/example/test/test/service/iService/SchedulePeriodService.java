package com.example.test.test.service.iService;


import com.example.test.test.DTO.CreatePeriodDTO;
import com.example.test.test.entity.SchedulePeriod;
import com.example.test.test.exception.NotFoundException;
import com.example.test.test.repository.EmployeeRep;
import com.example.test.test.repository.SchedulePeriodRep;
import com.example.test.test.repository.ScheduleRep;
import com.example.test.test.repository.ScheduleSlotRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SchedulePeriodService implements iSchedulePeriodService {

    @Autowired
    public SchedulePeriodRep _periodRep;
    @Autowired
    public EmployeeRep _employeeRep;
    @Autowired
    public ScheduleSlotRep _slotRep;
    @Autowired
    public ScheduleRep _scheduleRep;


    @Override
    public String createPeriod(CreatePeriodDTO dto) throws NotFoundException {
        return _periodRep.save(SchedulePeriod.builder()
                .executor(Objects.equals(dto.getExecutor_id(), dto.getAdministrator_id()) ? null : _employeeRep.findById(dto.getExecutor_id())
                        .orElseThrow(() ->
                                new NotFoundException("Сотрудник с id = '" + dto.getExecutor_id() + "' не найден")))
                .slot(_slotRep.findById(dto.getSlot_id())
                        .orElseThrow(() ->
                                new NotFoundException("Schedule Slot с id = '" + dto.getSlot_id() + "' не найден")))
                .schedule(_scheduleRep.findById(dto.getSchedule_id())
                        .orElseThrow(() ->
                                new NotFoundException("Schedule Template с id = '" + dto.getSchedule_id() + "' не найден")))
                .employee(_employeeRep.findById(dto.getAdministrator_id())
                        .orElseThrow(() ->
                                new NotFoundException("Сотрудник с id = '" + dto.getExecutor_id() + "' не найден")))
                .slot_type(dto.getSlot_type())
                .build()
        ).getId();


    }

    @Override
    public SchedulePeriod getPeriodById(String id) throws NotFoundException {
        return _periodRep.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Schedule Template с id = '" + id + "' не найден"));
    }
}
