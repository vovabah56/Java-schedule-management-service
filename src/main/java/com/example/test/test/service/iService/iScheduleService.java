package com.example.test.test.service.iService;

import com.example.test.test.DTO.CreateScheduleDTO;
import com.example.test.test.DTO.FullSchedule;
import com.example.test.test.entity.Schedule;
import com.example.test.test.exception.NotFoundException;

import java.util.UUID;

public interface iScheduleService {
    String createSchedule(CreateScheduleDTO dto);

    FullSchedule getScheduleByIdOrName(String id, String name) throws NotFoundException;
    Schedule getScheduleById(String id);
}
