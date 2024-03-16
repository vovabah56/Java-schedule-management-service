package com.example.test.test.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleTemplate
{
    @Id
    private String id;

    @PrePersist
    public void persist(){
        if(this.id ==null){
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }
    private LocalDateTime creation_date;
}
