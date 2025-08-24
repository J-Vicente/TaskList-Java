package com.Estudo.Tasklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estudo.Tasklist.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}

