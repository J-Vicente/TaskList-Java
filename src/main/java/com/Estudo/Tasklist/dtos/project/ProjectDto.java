package com.Estudo.Tasklist.dtos.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.Estudo.Tasklist.entities.Project;
import com.Estudo.Tasklist.entities.User;
import com.Estudo.Tasklist.entities.Task;


public class ProjectDto {

    private Long id;
    private String name;
    private String description;
    private String creator;
    private List<Task> tasks = new ArrayList<>();

    public ProjectDto() {
    }

    public ProjectDto(Project entity) {
        BeanUtils.copyProperties(entity, this);
        this.creator = entity.getCreator().getName();
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creatorId) {
        this.creator = creatorId;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

