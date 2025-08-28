package com.Estudo.Tasklist.dtos.auth;

import org.springframework.beans.BeanUtils;

import com.Estudo.Tasklist.entities.User;

public class UserDto {

    private Long id;
    private String name;
    private String email;

    public UserDto() {
    }
    
    public UserDto(User entity) {
        BeanUtils.copyProperties(entity, this);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
