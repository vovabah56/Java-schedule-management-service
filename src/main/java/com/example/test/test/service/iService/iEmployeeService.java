package com.example.test.test.service.iService;

import com.example.test.test.DTO.CreateEmployeeDTO;
import com.example.test.test.entity.Employee;
import com.example.test.test.exception.NotFoundException;

public interface iEmployeeService {


    String createEmployee(CreateEmployeeDTO dto);
    Employee getEmployeeById(String id) throws NotFoundException;
}
