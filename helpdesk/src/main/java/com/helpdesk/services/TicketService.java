package com.helpdesk.services;

import com.helpdesk.entities.Ticket;
import com.helpdesk.entities.User;
import com.helpdesk.repositories.TicketRepository;
import com.helpdesk.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class    TicketService {

    private final TicketRepository ticketRepository;
    private  final UserRepository userRepository;

    public Ticket create (Ticket payload , int userId){
        var user =userRepository.findById(userId).orElseThrow(
               ()->new RuntimeException("User not found with ID : "+userId));

        payload.setUser(user);

        var savedticket = this.ticketRepository.save(payload);

        return savedticket;
    }
    public Ticket update (Ticket payload , int userId, int ticketId){

        var user =userRepository.findById(userId).orElseThrow(
                ()->new RuntimeException("User not found with ID : "+userId));
        var ticket =ticketRepository.findById(ticketId).orElseThrow(
                ()->new RuntimeException("ticket not found with ID : "+ticketId));
//        List<User> listUser = ticket.getUser();
//        listUser.add(user);
//
//        ticket.setUsers(listUser);
        ticket.setStatus(payload.getStatus());

        return this.ticketRepository.save(ticket);
    }

    public List<Ticket> findAll( ){
        return this.ticketRepository.findAll();
    }
    public Ticket findOne(int id){

        return this.ticketRepository.findById(id).orElse(null);
    }
    public List<Ticket> findAllByUser(int id ){
        var user=this.userRepository.findById(id).orElse(null);
        if(user==null ){
           throw new RuntimeException("User not Found ");
        }
        return  this.ticketRepository.findTicketsByUserId(id);
    }
    public void delete(int id ){
        var foundTicket = this.findOne(id);
        if(foundTicket!=null)
        {
            this.ticketRepository.delete(foundTicket);
        }
    }

}

