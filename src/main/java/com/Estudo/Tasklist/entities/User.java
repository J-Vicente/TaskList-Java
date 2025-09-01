package com.Estudo.Tasklist.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_users")
public class User {

    @Id 
    @GeneratedValue
    private Long id;

    @NotBlank(message = "O nome não pode ser vazio")
    private String name;    

    @Email(message = "E-mail inválido")
    private String email;
    
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String password;

    @OneToMany(mappedBy = "creator")
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "responsibles")
    private List<Task> tasks = new ArrayList<>();

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }   

    public void setEmail(String email) {
        this.email = email;
    }   

    public String getPassword() {
        return password;
    }   

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return id == user.id;
    }
}
