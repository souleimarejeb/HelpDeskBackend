package com.helpdesk.entities;

import com.helpdesk.entities.enums.Priorities;
import com.helpdesk.entities.enums.Status;
import com.helpdesk.entities.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ticketId;

    String title;

    String type;

    String priority;

    String description ;


    Status status=Status.Pending;


    private LocalDate createdAt;


    LocalDate updatedAt;

    @OneToOne()
    Category category;

    @ManyToOne
    private User user;




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
