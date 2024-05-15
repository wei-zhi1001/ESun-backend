package com.example.esun.dao;

import com.example.esun.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<Users, Long> {
    Users findByUserId(Long id);
}
