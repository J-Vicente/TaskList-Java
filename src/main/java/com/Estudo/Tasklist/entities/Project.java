package com.Estudo.Tasklist.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_projects")
public class Project {

    @Id 
    @GeneratedValue
    private Long id;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne 
    @JoinColumn(name = "creator_id")
    private User creator;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    public Project() {
    }

    public Project(String name, String description, User creator) {
        this.name = name;
        this.description = description;
        this.creator = creator;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Project project = (Project) obj;
        return id == project.id;
    }
}
