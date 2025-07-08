package com.helpdesk.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    String name;

    String password;

    LocalDate createdAt;

    LocalDate updatedAt;

    @OneToMany()
    List<Ticket> tickets = new ArrayList<>();


    @PrePersist
    void beforeInsert(){
        createdAt = LocalDate.now();
        updatedAt= LocalDate.now();
    }
    @PreUpdate
    void beforeUpdate() {
        updatedAt = LocalDate.now();
    }
}
