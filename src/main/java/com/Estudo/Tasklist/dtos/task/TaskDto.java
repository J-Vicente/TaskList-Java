package com.Estudo.Tasklist.dtos.task;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.Estudo.Tasklist.entities.Coment;
import com.Estudo.Tasklist.entities.Project;
import com.Estudo.Tasklist.entities.Status;
import com.Estudo.Tasklist.entities.Task;
import com.Estudo.Tasklist.entities.User;

public class TaskDto {

    private Long id;
    private String name;
    private LocalDate term;
    private String description;
    private Status status;
    private Long projectId;
    private List<User> responsibles;
    private List<Coment> coments;

    public TaskDto() {
    }

    public TaskDto(Task entity) {
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public List<User> getResponsibles() {
        return responsibles;
    }

    public void setResponsibles(List<User> responsibles) {
        this.responsibles = responsibles;
    }

    public List<Coment> getComent() {
        return coments;
    }

    public void setComent(List<Coment> coments) {
        this.coments = coments;
    }

    public LocalDate getTerm() {
        return term;
    }

    public void setTerm(LocalDate term) {
        this.term = term;
    }
}
