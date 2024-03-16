package com.example.test.test.service;

import com.example.test.test.DTO.CreateEmployeeDTO;
import com.example.test.test.entity.Employee;
import com.example.test.test.exception.NotFoundException;
import com.example.test.test.repository.EmployeeRep;
import com.example.test.test.service.iService.iEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements iEmployeeService {

    @Autowired
    public EmployeeRep _employeeRep;

    @Override
    public String createEmployee(CreateEmployeeDTO dto) {
        return _employeeRep.save(Employee.builder()
                .employee_name(dto.getEmployee_name())
                .position(dto.getPosition())
                .status(dto.getStatus())
                .build())
                .getId();
    }

    @Override
    public Employee getEmployeeById(String id) throws NotFoundException {
        return _employeeRep.findById(id).orElseThrow(()-> new NotFoundException("Employee с id = '" + id + "' не найден"));
    }
}
