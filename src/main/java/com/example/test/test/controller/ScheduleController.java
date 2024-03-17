package com.example.test.test.controller;


import com.example.test.test.DTO.CreateScheduleDTO;
import com.example.test.test.DTO.FullSchedule;
import com.example.test.test.entity.Employee;
import com.example.test.test.entity.Schedule;
import com.example.test.test.exception.NotFoundException;
import com.example.test.test.service.iService.iScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * Контроллер для {@code CR} операций над {@link Schedule}
 */

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    public iScheduleService _scheduleService;

    /**
     * Метод для создания нового Расписания.
     *
     * @param dto dto с данными для нового Расписания.
     * @return  идентификатор Созданного расписания.
     */
    @PostMapping()
    public ResponseEntity<String> createSchedule(@Valid @RequestBody CreateScheduleDTO dto){
        return new ResponseEntity<>(_scheduleService.createSchedule(dto), HttpStatus.OK);
    }

    /**
     * Метод для получения Расписания по id.
     *
     * @return Сущность расписания.
     */


    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable String id){
        return new ResponseEntity<>(_scheduleService.getScheduleById(id), HttpStatus.OK);
    }

    /**
     * Метод для получения Расписания по id или name.
     *
     * @return Расписание со всеми связанными элементами.
     */
    @GetMapping
    public ResponseEntity<FullSchedule> getScheduleByIdOrName(@RequestParam(name = "id", required = false) String id,
                                                              @RequestParam(name = "name", required = false) String name) throws NotFoundException {
        return new ResponseEntity<>(_scheduleService.getScheduleByIdOrName(id, name), HttpStatus.OK);
    }

}
