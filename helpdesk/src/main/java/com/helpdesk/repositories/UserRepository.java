package com.helpdesk.repositories;

import com.helpdesk.entities.Category;
import com.helpdesk.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
