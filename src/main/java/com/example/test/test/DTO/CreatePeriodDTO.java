package com.example.test.test.DTO;

import com.example.test.test.entity.enums.PeriodType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;



@Data
@Builder

public class CreatePeriodDTO {
    @NotNull
    private String slot_id;
    @NotNull
    private String schedule_id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PeriodType slot_type;
    @NotNull
    private String administrator_id;
    @NotNull
    private String executor_id;
}
