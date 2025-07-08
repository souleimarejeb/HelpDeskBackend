package com.helpdesk.controllers;

import com.helpdesk.entities.Ticket;
import com.helpdesk.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/ticket")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getOne(@PathVariable int id) {
        return ResponseEntity.ok(ticketService.findOne(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Ticket>> getAll() {
        return ResponseEntity.ok(ticketService.findAll());
    }
    @PostMapping("/{userId}")
    public ResponseEntity<Ticket> create(
            @RequestBody Ticket payload,
            @PathVariable int userId
            ) {
        return ResponseEntity.ok(ticketService.create(payload,userId));
    }
    @PatchMapping("/{ticketId}/user/{userId}")
    public ResponseEntity<Ticket> update(
            @RequestBody Ticket payload,
            @PathVariable int userId,
            @PathVariable int ticketId
    ) {
        return ResponseEntity.ok(ticketService.update(payload,userId,ticketId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ticket> delete(@PathVariable int id) {
        ticketService.delete(id);
        return ResponseEntity.ok().build();
    }
}
