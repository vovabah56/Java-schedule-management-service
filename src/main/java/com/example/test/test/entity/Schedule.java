package com.example.test.test.entity;
import jakarta.annotation.Nullable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrePersist;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {
    @Id
    private String id;

    @Nullable
    private String name;

    @PrePersist
    public void persist(){
        if(this.id ==null){
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }


    private LocalDateTime creation_date;

}
