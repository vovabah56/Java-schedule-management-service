package com.example.test.test.repository;

import com.example.test.test.entity.SchedulePeriod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulePeriodRep extends JpaRepository<SchedulePeriod, String> {
}
