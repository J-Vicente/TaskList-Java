package com.Estudo.Tasklist.dtos.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.Estudo.Tasklist.entities.Project;


public class NewProjectDto {

    private String name;
    private String description;
    private long creatorId;

    public NewProjectDto() {
    }

    public NewProjectDto(Project entity) {
        BeanUtils.copyProperties(entity, this);
        this.creatorId = entity.getCreator().getId();
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

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }
}


