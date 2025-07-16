package com.helpdesk.services;

import com.helpdesk.entities.Role;
import com.helpdesk.repositories.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role createRole(Role role) {
        try {
            return roleRepository.save(role);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create role: " + e.getMessage(), e);
        }
    }

    public List<Role> getAllRoles() {
        try {
            return roleRepository.findAll();
        } catch (Exception e) {

            return Collections.emptyList();
        }
    }

    public Role getRoleById(int id) {
        try {
            return roleRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch role by id: " + id, e);
        }
    }

    public Role updateRole(int id, Role updatedRole) {
        try {
            Role role = getRoleById(id);
            role.setName(updatedRole.getName());
            return roleRepository.save(role);
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to update role with id: " + id, e);
        }
    }

    public void deleteRole(int id) {
        try {
            Role role = getRoleById(id);
            roleRepository.delete(role);
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete role with id: " + id, e);
        }
    }
}
