package com.helpdesk.services;

import com.helpdesk.entities.Ticket;
import com.helpdesk.entities.User;
import com.helpdesk.repositories.TicketRepository;
import com.helpdesk.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create (User payload){
       return this.userRepository.save(payload);
    }

    public List<User> findAll( ){
        return this.userRepository.findAll();
    }


    public User update ( User payload , int id ){
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        user=payload;
        return userRepository.save(user);

    }
    public User findOne(int id){

        return this.userRepository.findById(id).orElse(null);
    }

    public void delete(int id ){
        var foundTicket = this.findOne(id);
        if(foundTicket!=null)
        {
            this.userRepository.delete(foundTicket);
        }
    }

}

