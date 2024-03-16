package com.example.test.test.controller;


import com.example.test.test.entity.ScheduleTemplate;
import com.example.test.test.exception.NotFoundException;
import com.example.test.test.service.iService.iScheduleTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/template")
public class ScheduleTemplateController {

    @Autowired
    public iScheduleTemplateService _templateService;

    @PostMapping
    public ResponseEntity<String> createTemplate(){
        return new ResponseEntity<>(_templateService.createTemplate(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleTemplate> getTemplateById(@PathVariable String id) throws NotFoundException {
        return new ResponseEntity<>(_templateService.getTemplateById(id), HttpStatus.OK);

    }

}
