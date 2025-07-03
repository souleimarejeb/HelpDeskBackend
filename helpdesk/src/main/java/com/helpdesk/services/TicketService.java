package com.helpdesk.services;

import com.helpdesk.entities.Ticket;
import com.helpdesk.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public Ticket create (Ticket payload){
       return this.ticketRepository.save(payload);
    }

    public List<Ticket> findAll( ){
        return this.ticketRepository.findAll();
    }
    public Ticket findOne(int id){

        return this.ticketRepository.findById(id).orElse(null);
    }

    public void delete(int id ){
        var foundTicket = this.findOne(id);
        if(foundTicket!=null)
        {
            this.ticketRepository.delete(foundTicket);
        }
    }

}

