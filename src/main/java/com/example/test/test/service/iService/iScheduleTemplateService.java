package com.example.test.test.service.iService;

import com.example.test.test.entity.ScheduleTemplate;
import com.example.test.test.exception.NotFoundException;

public interface iScheduleTemplateService {


    String createTemplate();
    ScheduleTemplate getTemplateById(String id) throws NotFoundException;
}
