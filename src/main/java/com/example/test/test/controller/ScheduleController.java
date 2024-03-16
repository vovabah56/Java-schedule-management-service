package com.example.test.test.controller;


import com.example.test.test.DTO.CreateScheduleDTO;
import com.example.test.test.entity.Schedule;
import com.example.test.test.service.iService.iScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    public iScheduleService _scheduleService;


    @PostMapping()
    public ResponseEntity<String> createSchedule(@Valid @RequestBody CreateScheduleDTO dto){
        return new ResponseEntity<>(_scheduleService.createSchedule(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable String id){
        return new ResponseEntity<>(_scheduleService.getScheduleById(id), HttpStatus.OK);
    }

}
