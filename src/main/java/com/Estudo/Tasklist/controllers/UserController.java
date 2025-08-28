package com.Estudo.Tasklist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.Estudo.Tasklist.dtos.auth.LoginDto;
import com.Estudo.Tasklist.dtos.auth.RegistrationDto;
import com.Estudo.Tasklist.dtos.auth.UserDto;
import com.Estudo.Tasklist.services.UserService;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<UserDto> register(@Validated @RequestBody RegistrationDto dto) {
        UserDto response = userService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@Valid @RequestBody LoginDto dto) {
        UserDto response = userService.login(dto);
        return ResponseEntity.ok(response);
    }
}
