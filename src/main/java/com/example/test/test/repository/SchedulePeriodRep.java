package com.example.test.test.repository;

import com.example.test.test.entity.SchedulePeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.Period;
import java.util.List;
import java.util.Optional;

public interface SchedulePeriodRep extends JpaRepository<SchedulePeriod, String>, JpaSpecificationExecutor<SchedulePeriod> {


    List<SchedulePeriod> findSchedulePeriodsByEmployeeIdAndScheduleId(String id, String Sid);
    List<SchedulePeriod> findSchedulePeriodsByExecutorIdAndScheduleId(String id, String Sid);
    Optional<SchedulePeriod> findByEmployeeId(String id);
    Optional<SchedulePeriod> findByExecutorId(String id);
}
