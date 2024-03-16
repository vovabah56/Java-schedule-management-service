package com.example.test.test.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleSlot {
    @Id
    private String id;

    @PrePersist
    public void persist(){
        if(this.id ==null){
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }
    @ManyToOne
    @JoinColumn(name = "schedule_template_id")
    private ScheduleTemplate template;


    private LocalTime begin_time;

    private LocalTime end_time;

}
