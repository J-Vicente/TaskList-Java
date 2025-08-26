package com.Estudo.Tasklist.dtos.project;

import org.springframework.beans.BeanUtils;

import com.Estudo.Tasklist.entities.Project;
import com.Estudo.Tasklist.entities.User;


public class ProjectAllDto {

    private Long id;
    private String name;
    private String description;
    private String creator;

    public ProjectAllDto() {
    }

    public ProjectAllDto(Project entity) {
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
}

