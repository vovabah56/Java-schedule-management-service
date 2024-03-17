package com.example.test.test.service.iService;

import com.example.test.test.DTO.CreatePeriodDTO;
import com.example.test.test.DTO.FilterDTO;
import com.example.test.test.DTO.PeriodsPage;
import com.example.test.test.entity.SchedulePeriod;
import com.example.test.test.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface iSchedulePeriodService {
    String createPeriod(CreatePeriodDTO dto) throws NotFoundException;
    SchedulePeriod getPeriodById(String id) throws NotFoundException;

    Page<SchedulePeriod> getPeriods(FilterDTO filter, String field, String direction, int pageNumber, int pageSize);
}
