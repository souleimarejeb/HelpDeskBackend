package com.helpdesk.controllers;

import com.helpdesk.entities.User;
import com.helpdesk.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable int id) {
        return ResponseEntity.ok(userService.findOne(id));
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<User> create(
            @RequestBody User payload) {
        return ResponseEntity.ok(userService.create(payload));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
