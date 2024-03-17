package com.example.test.test.repository;

import com.example.test.test.entity.Employee;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRep extends JpaRepository<Employee, String> {

}
