package com.example.test.test.DTO;

import com.example.test.test.entity.ScheduleTemplate;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;


@Data
@Getter
@Setter
@Builder
public class CreateSlotDto {

    private String template_id;
    private LocalTime begin_time;
    private LocalTime end_time;
}
