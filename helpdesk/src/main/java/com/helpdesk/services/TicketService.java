package com.helpdesk.services;

import com.helpdesk.entities.Ticket;
import com.helpdesk.repositories.TicketRepository;
import com.helpdesk.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private  final UserRepository userRepository;

    public Ticket create (Ticket payload , int userId){
        var user =userRepository.findById(userId).orElseThrow(
               ()->new RuntimeException("User not found with ID : "+userId));

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

