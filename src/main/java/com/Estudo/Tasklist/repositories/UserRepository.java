package com.Estudo.Tasklist.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estudo.Tasklist.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
