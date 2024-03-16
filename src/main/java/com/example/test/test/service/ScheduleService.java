package com.example.test.test.service;

import com.example.test.test.DTO.CreateScheduleDTO;
import com.example.test.test.entity.Schedule;
import com.example.test.test.repository.ScheduleRep;
import com.example.test.test.service.iService.iScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduleService implements iScheduleService {
    @Autowired
    public ScheduleRep scheduleRep;


    public String createSchedule(CreateScheduleDTO dto) {
        return scheduleRep.save(Schedule.builder()
                .schedule_name(dto.getSchedule_name())
                .creation_date(LocalDateTime.now())
                .build()).getId();

    }

    @Override
    public Schedule getScheduleById(String id) {
        return scheduleRep.findById(id).orElse(null);
    }

}
