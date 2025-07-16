package com.helpdesk.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    LocalDate createdAt;

    LocalDate updatedAt;

    @PrePersist
    void beforeInsert(){
        createdAt = LocalDate.now();
        updatedAt= LocalDate.now();
    }

    @PreUpdate
    void beforeUpdate() {
        updatedAt = LocalDate.now();
    }

    @OneToMany(mappedBy = "role")
    private List<User> users;

}
