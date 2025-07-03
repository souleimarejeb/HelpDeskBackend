package com.helpdesk.entities;

import com.helpdesk.entities.enums.Priorities;
import com.helpdesk.entities.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

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

    Type type;

    Priorities priority;

    String description ;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    LocalDate contractUpdatedAt;

    @OneToOne()
    Ticket ticket;

}
