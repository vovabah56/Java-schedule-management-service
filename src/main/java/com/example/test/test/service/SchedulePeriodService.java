package com.example.test.test.service;


import com.example.test.test.DTO.CreatePeriodDTO;
import com.example.test.test.DTO.FilterDTO;
import com.example.test.test.DTO.PeriodsPage;
import com.example.test.test.entity.SchedulePeriod;
import com.example.test.test.entity.ScheduleSlot;
import com.example.test.test.exception.BadRequestException;
import com.example.test.test.exception.NotFoundException;
import com.example.test.test.repository.EmployeeRep;
import com.example.test.test.repository.SchedulePeriodRep;
import com.example.test.test.repository.ScheduleRep;
import com.example.test.test.repository.ScheduleSlotRep;
import com.example.test.test.service.iService.iSchedulePeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.Period;
import java.util.List;
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
        checkSlotTime(dto);



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

    public void checkSlotTime(CreatePeriodDTO dto) throws NotFoundException{


        List<SchedulePeriod> periods;
        if(Objects.equals(dto.getAdministrator_id(), dto.getExecutor_id())) {
             periods = _periodRep.findSchedulePeriodsByEmployeeIdAndScheduleIdAndExecutorId(dto.getAdministrator_id(), dto.getSchedule_id(), null);
        }
        else {
             periods = _periodRep.findSchedulePeriodsByExecutorIdAndScheduleId(dto.getExecutor_id(), dto.getSchedule_id());
        }

        ScheduleSlot slot = _slotRep.findById(dto.getSlot_id())
                .orElseThrow(() ->
                        new NotFoundException("Слот с id = '" + dto.getSlot_id() + "' не найден"));


        periods.forEach((period)->{
            if(areTimeSegmentsIntersecting(period.getSlot().getBegin_time(), period.getSlot().getEnd_time(), slot.getBegin_time(), slot.getEnd_time())){
                try {
                    throw new BadRequestException("У сотрудника уже существует период на данное время");
                } catch (BadRequestException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }



    @Override
    public SchedulePeriod getPeriodById(String id) throws NotFoundException {
        return _periodRep.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Schedule Template с id = '" + id + "' не найден"));
    }

    @Override
    public Page<SchedulePeriod> getPeriods(FilterDTO filter, String field, String direction, int pageNumber, int pageSize) {
        if(field == null){
            return _periodRep.findAll(FilterSpecification.getSpecification(filter), PageRequest.of(pageNumber, pageSize));
        }
        return _periodRep.findAll(FilterSpecification.getSpecification(filter), PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Objects.equals(direction, "ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, field)));
    }



    public boolean areTimeSegmentsIntersecting(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        return !end1.isBefore(start2) && !start1.isAfter(end2);
    }
}
