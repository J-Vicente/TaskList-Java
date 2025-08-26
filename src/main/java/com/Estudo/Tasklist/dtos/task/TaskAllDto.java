package com.Estudo.Tasklist.dtos.task;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.Estudo.Tasklist.entities.Status;
import com.Estudo.Tasklist.entities.Task;


public class TaskAllDto {
    private Long id;
    private String name;
    private LocalDate term;
    private String description;
    private Status status;


    public TaskAllDto() {
    }

    public TaskAllDto(Task entity) {
       BeanUtils.copyProperties(entity, this);          
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getTerm() {
        return term;
    }

    public void setTerm(LocalDate term) {
        this.term = term;
    }
}


