package com.helpdesk.services;

import com.helpdesk.entities.Role;
import com.helpdesk.entities.User;
import com.helpdesk.repositories.RoleRepository;
import com.helpdesk.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User create(User payload) {
        Role role = resolveRole(payload.getRole().getId());
        payload.setRole(role);
        return userRepository.save(payload);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User update(User payload, int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));

        user.setName(payload.getName());
        user.setPassword(payload.getPassword());

        if (payload.getRole() != null) {
            Role role = resolveRole(payload.getRole().getId());
            user.setRole(role);
        }

        return userRepository.save(user);
    }

    public void delete(int id) {
        User foundUser = this.findOne(id);
        if (foundUser != null) {
            this.userRepository.delete(foundUser);
        }
    }

    private Role resolveRole(int roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with ID: " + roleId));
    }
}
