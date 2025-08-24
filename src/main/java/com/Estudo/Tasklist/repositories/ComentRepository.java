package com.Estudo.Tasklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estudo.Tasklist.entities.Coment;

public interface ComentRepository extends JpaRepository<Coment, Long> {
    
}
