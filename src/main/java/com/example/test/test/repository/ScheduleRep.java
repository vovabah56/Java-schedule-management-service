package com.example.test.test.repository;

import com.example.test.test.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRep extends JpaRepository<Schedule, String> {
}
