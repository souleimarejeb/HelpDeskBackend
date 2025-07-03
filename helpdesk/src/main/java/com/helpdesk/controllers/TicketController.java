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
    @PostMapping("")
    public ResponseEntity<Ticket> create(@RequestBody Ticket payload) {
        return ResponseEntity.ok(ticketService.create(payload));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ticket> delete(@PathVariable int id) {
        ticketService.delete(id);
        return ResponseEntity.ok().build();
    }
}
