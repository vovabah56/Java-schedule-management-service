package com.example.test.test.entity;


import com.example.test.test.entity.enums.Position;
import com.example.test.test.entity.enums.Status;
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
public class Employee {
    @Id
    private String id;

    @PrePersist
    public void persist(){
        if(this.id ==null){
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }
    private String employee_name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Position position;


}
