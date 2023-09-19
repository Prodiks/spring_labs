package com.example.lab_7.repository;

import com.example.lab_7.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
