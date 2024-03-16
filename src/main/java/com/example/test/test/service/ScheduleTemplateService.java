package com.example.test.test.service;

import com.example.test.test.entity.ScheduleSlot;
import com.example.test.test.entity.ScheduleTemplate;
import com.example.test.test.exception.NotFoundException;
import com.example.test.test.repository.ScheduleTemplateRep;
import com.example.test.test.service.iService.iScheduleTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ScheduleTemplateService implements iScheduleTemplateService {


    @Autowired
    public ScheduleTemplateRep _templateRep;
    @Override
    public String createTemplate() {
        return _templateRep.save(ScheduleTemplate.builder()
                .creation_date(LocalDateTime.now())
                .build()).getId();
    }

    @Override
    public ScheduleTemplate getTemplateById(String id) throws NotFoundException {
        return _templateRep.findById(id).orElseThrow(() -> new NotFoundException("Schedule Template с id = " + id + " не найден"));

    }
}
