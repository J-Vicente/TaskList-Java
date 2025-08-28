package com.Estudo.Tasklist.dtos.auth;

import org.springframework.beans.BeanUtils;

import com.Estudo.Tasklist.entities.User;

public class LoginDto {
    
    private String email;
    private String password;

    public LoginDto() {
    }
    
    public LoginDto(User entity) {
        BeanUtils.copyProperties(entity, this);
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
