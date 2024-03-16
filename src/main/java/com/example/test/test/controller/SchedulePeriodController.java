package com.example.test.test.controller;


import com.example.test.test.DTO.CreatePeriodDTO;
import com.example.test.test.entity.SchedulePeriod;
import com.example.test.test.exception.NotFoundException;
import com.example.test.test.service.iService.iSchedulePeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/period")
public class SchedulePeriodController {

    @Autowired
    public iSchedulePeriodService _periodService;


    @PostMapping
    public ResponseEntity<String> createPeriod(@RequestBody CreatePeriodDTO dto) throws NotFoundException {
        return new ResponseEntity<>(_periodService.createPeriod(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulePeriod> getPeriodById(@PathVariable String id) throws NotFoundException {
        return new ResponseEntity<>(_periodService.getPeriodById(id), HttpStatus.OK);
    }
}
