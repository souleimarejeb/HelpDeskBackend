package com.helpdesk.repositories;

import com.helpdesk.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    @Query("SELECT t FROM Ticket t WHERE t.user.userId = :userId")
    List<Ticket> findTicketsByUserId(@Param("userId") int userId);
}
