package com.example.test.test.service;

import com.example.test.test.DTO.CreateScheduleDTO;
import com.example.test.test.DTO.FullSchedule;
import com.example.test.test.entity.Schedule;
import com.example.test.test.entity.SchedulePeriod;
import com.example.test.test.exception.NotFoundException;
import com.example.test.test.repository.SchedulePeriodRep;
import com.example.test.test.repository.ScheduleRep;
import com.example.test.test.service.iService.iScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduleService implements iScheduleService {
    @Autowired
    public ScheduleRep scheduleRep;
    @Autowired
    public SchedulePeriodRep _periodRep;


    public String createSchedule(CreateScheduleDTO dto) {

        return scheduleRep.save(Schedule.builder()
                .name(dto.getSchedule_name())
                .creation_date(LocalDateTime.now())
                .build()).getId();
    }

    @Override
    public FullSchedule getScheduleByIdOrName(String id, String name) throws NotFoundException {

        Schedule schedule;
        if(id != null){
            schedule = scheduleRep.findById(id).orElseThrow(() ->
                    new NotFoundException("Сотрудник с id = '" + id + "' не найден"));
        }
        else if (name != null){
            schedule = scheduleRep.findScheduleByName(name)
                    .orElseThrow(() ->
                            new NotFoundException("Сотрудник с name = '" + name + "' не найден"));
        }
        else{
            throw new NotFoundException("id или name не указаны");
        }
        FullSchedule fullSchedule = new FullSchedule();
        fullSchedule.setId(schedule.getId());
        fullSchedule.setSchedule_name(schedule.getName());
        fullSchedule.setCreation_date(schedule.getCreation_date());
        fullSchedule.setPeriods(_periodRep.findSchedulePeriodsByScheduleId(schedule.getId()));

        return fullSchedule;
    }

    @Override
    public Schedule getScheduleById(String id) {

        return scheduleRep.findById(id).orElse(null);
    }

}
