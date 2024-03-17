package com.example.test.test.DTO;

import com.example.test.test.entity.Schedule;
import com.example.test.test.entity.SchedulePeriod;
import jakarta.annotation.Nullable;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class FullSchedule {
    private String id;

    private String schedule_name;



    private LocalDateTime creation_date;

    private List<SchedulePeriod> periods;
}
