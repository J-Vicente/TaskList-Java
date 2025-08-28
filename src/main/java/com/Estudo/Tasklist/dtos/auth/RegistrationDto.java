package com.Estudo.Tasklist.dtos.auth;

import org.springframework.beans.BeanUtils;

import com.Estudo.Tasklist.entities.User;

public class RegistrationDto {
    
    private String name;
    private String email;
    private String password;

    public RegistrationDto() {
    }
    
    public RegistrationDto(User entity) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
