package com.example.test.test.DTO;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;

@Data
public class FilterDTO {
    @Nullable
    String id;
    @Nullable
    String slotId;
    @Nullable
    String scheduleId;
    @Nullable
    @Pattern(regexp = "^(LOCAL|FROM_HOME|UNDEFINED)?$", message = "Неверное значение для поля slotType")
    String slotType;
    @Nullable
    String administratorId;
    @Nullable
    String executorId;
    @Nullable
    private String begin_time;
    @Nullable
    private String end_time;
}
