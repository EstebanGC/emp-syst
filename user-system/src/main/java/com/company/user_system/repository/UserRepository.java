package com.company.user_system.repository;

import com.company.user_system.entity.Role;
import com.company.user_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Role findByEmail(String username);
}
