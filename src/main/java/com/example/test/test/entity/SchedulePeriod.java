package com.example.test.test.entity;


import com.example.test.test.entity.enums.PeriodType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchedulePeriod {
    @Id
    private String id;

    @PrePersist
    public void persist(){
        if(this.id ==null){
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private ScheduleSlot slot;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Enumerated(EnumType.STRING)
    private PeriodType slot_type;

    @ManyToOne
    @JoinColumn(name = "administrator_id")
    private Employee employee;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "executor_id")
    private Employee executor;



}
