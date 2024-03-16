package com.example.test.test.repository;

import com.example.test.test.entity.ScheduleSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleSlotRep extends JpaRepository<ScheduleSlot, String> {
}
