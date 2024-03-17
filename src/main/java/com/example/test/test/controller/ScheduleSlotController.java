package com.example.test.test.controller;


import com.example.test.test.DTO.CreateSlotDto;
import com.example.test.test.entity.ScheduleSlot;
import com.example.test.test.exception.BadRequestException;
import com.example.test.test.exception.NotFoundException;
import com.example.test.test.service.iService.iScheduleSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/slot")
public class ScheduleSlotController {

    @Autowired
    public iScheduleSlotService _slotService;
    @PostMapping
    public ResponseEntity<String> createSlot(@RequestBody CreateSlotDto dto) throws NotFoundException, BadRequestException {
        return new ResponseEntity<>(_slotService.createSlot(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleSlot> getSlotBId(@PathVariable String id) throws NotFoundException{
        return new ResponseEntity<>(_slotService.getSlotById(id), HttpStatus.OK);
    }


}
