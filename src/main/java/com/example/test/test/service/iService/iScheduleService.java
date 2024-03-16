package com.example.test.test.service.iService;

import com.example.test.test.DTO.CreateScheduleDTO;
import com.example.test.test.entity.Schedule;

import java.util.UUID;

public interface iScheduleService {
    String createSchedule(CreateScheduleDTO dto);

    Schedule getScheduleById(String id);
}
