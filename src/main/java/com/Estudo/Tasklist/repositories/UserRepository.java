package com.Estudo.Tasklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estudo.Tasklist.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
