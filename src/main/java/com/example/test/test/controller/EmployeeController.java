package com.example.test.test.controller;


import com.example.test.test.DTO.CreateEmployeeDTO;
import com.example.test.test.entity.Employee;
import com.example.test.test.exception.NotFoundException;
import com.example.test.test.service.iService.iEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    public iEmployeeService _employeeService;


    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody CreateEmployeeDTO dto){
        return new ResponseEntity<>(_employeeService.createEmployee(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) throws NotFoundException {
        return new ResponseEntity<>(_employeeService.getEmployeeById(id), HttpStatus.OK);
    }

}
