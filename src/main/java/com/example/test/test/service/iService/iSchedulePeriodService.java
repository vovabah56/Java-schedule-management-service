package com.example.test.test.service.iService;

import com.example.test.test.DTO.CreatePeriodDTO;
import com.example.test.test.entity.SchedulePeriod;
import com.example.test.test.exception.NotFoundException;

public interface iSchedulePeriodService {
    String createPeriod(CreatePeriodDTO dto) throws NotFoundException;
    SchedulePeriod getPeriodById(String id) throws NotFoundException;
}
