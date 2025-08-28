package com.Estudo.Tasklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estudo.Tasklist.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
