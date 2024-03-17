package com.example.test.test.controller;


import com.example.test.test.DTO.CreatePeriodDTO;
import com.example.test.test.DTO.FilterDTO;
import com.example.test.test.DTO.PeriodsPage;
import com.example.test.test.entity.SchedulePeriod;
import com.example.test.test.exception.NotFoundException;
import com.example.test.test.service.iService.iSchedulePeriodService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/period")
@Slf4j
public class SchedulePeriodController {

    @Autowired
    public iSchedulePeriodService _periodService;

    @PostMapping
    public ResponseEntity<String> createPeriod(@RequestBody CreatePeriodDTO dto) throws NotFoundException {

        return new ResponseEntity<>(_periodService.createPeriod(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulePeriod> getPeriodById(@PathVariable String id)
            throws NotFoundException {
        return new ResponseEntity<>(_periodService.getPeriodById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<SchedulePeriod>> getPeriodsWithFilter(@Valid @RequestParam(required = false) FilterDTO filter,
                                                                     @RequestParam(value = "field", required = false) String field,
                                                                     @RequestParam(value = "direction", required = false) String direction,
                                                                     @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                     @RequestParam(value = "pageSize", required = false) Integer pageSize){

        return new ResponseEntity<>(_periodService.getPeriods(filter, field, direction, pageNumber, pageSize), HttpStatus.OK);
    }


}
