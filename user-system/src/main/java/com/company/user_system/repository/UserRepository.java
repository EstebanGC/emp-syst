package com.company.user_system.repository;

import com.company.user_system.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Role, Long> {
    Role findByEmail(String username);
}
