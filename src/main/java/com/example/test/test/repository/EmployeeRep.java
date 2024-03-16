package com.example.test.test.repository;

import com.example.test.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRep extends JpaRepository<Employee, String> {
}
