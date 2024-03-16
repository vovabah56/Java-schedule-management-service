package com.example.test.test.DTO;

import com.example.test.test.entity.enums.Position;
import com.example.test.test.entity.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;


@Data
public class CreateEmployeeDTO {
    private String employee_name;

    @Enumerated(EnumType.STRING)
    private Status status;


    @Enumerated(EnumType.STRING)
    private Position position;
}
