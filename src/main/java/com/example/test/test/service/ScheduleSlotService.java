package com.example.test.test.service;

import com.example.test.test.DTO.CreateSlotDto;
import com.example.test.test.entity.ScheduleSlot;
import com.example.test.test.entity.ScheduleTemplate;
import com.example.test.test.exception.NotFoundException;
import com.example.test.test.repository.ScheduleSlotRep;
import com.example.test.test.repository.ScheduleTemplateRep;
import com.example.test.test.service.iService.iScheduleSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class ScheduleSlotService implements iScheduleSlotService {


    @Autowired
    public ScheduleSlotRep _slotRep;
    @Autowired
    public ScheduleTemplateRep _templateRep;
    @Override
    public ScheduleSlot getSlotById(String id) throws NotFoundException {
        return _slotRep.findById(id).orElseThrow(() -> new NotFoundException("Schedule Slot с id = " + id + " не найден"));
    }

    @Override
    public String createSlot(CreateSlotDto dto) throws NotFoundException {
        ScheduleTemplate template = _templateRep
                .findById(dto.getTemplate_id())
                .orElseThrow(() -> new NotFoundException("Schedule Template с id = '" + dto.getTemplate_id() + "' не найден"));

        return _slotRep.save(ScheduleSlot.builder()
                .begin_time(dto.getBegin_time())
                .end_time(dto.getEnd_time())
                .template(template).build()).getId();

    }



}
