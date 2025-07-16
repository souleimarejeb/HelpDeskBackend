package com.helpdesk.repositories;

import com.helpdesk.entities.Category;
import com.helpdesk.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
