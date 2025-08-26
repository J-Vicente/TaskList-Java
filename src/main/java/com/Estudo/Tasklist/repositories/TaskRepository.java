package com.Estudo.Tasklist.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estudo.Tasklist.entities.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjectId(Long projectId);
    Optional<Task> findByIdAndProjectId(Long id, Long projectId);
}

