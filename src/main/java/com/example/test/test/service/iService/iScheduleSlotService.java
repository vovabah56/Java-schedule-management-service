package com.example.test.test.service.iService;

import com.example.test.test.DTO.CreateSlotDto;
import com.example.test.test.entity.ScheduleSlot;
import com.example.test.test.exception.BadRequestException;
import com.example.test.test.exception.NotFoundException;

public interface iScheduleSlotService {

    ScheduleSlot getSlotById(String id) throws NotFoundException;

    String createSlot(CreateSlotDto dto) throws NotFoundException, BadRequestException;

}
