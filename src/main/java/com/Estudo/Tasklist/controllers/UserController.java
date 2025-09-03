package com.Estudo.Tasklist.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Estudo.Tasklist.dtos.auth.LoginDto;
import com.Estudo.Tasklist.dtos.auth.RegistrationDto;
import com.Estudo.Tasklist.dtos.auth.UserDto;
import com.Estudo.Tasklist.dtos.responses.ApiResponse;
import com.Estudo.Tasklist.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<ApiResponse<UserDto>> register(@Valid @RequestBody RegistrationDto dto) {
        UserDto newUser = userService.register(dto);

        ApiResponse<UserDto> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(newUser);
        response.setMessage("Usuário criado com sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")

    public ResponseEntity<Map<String,String>> login(@Valid @RequestBody LoginDto dto) {
        String token = userService.login(dto);
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

    // public ResponseEntity<ApiResponse<String>> login(@Valid @RequestBody LoginDto dto) {
    //     String token = userService.login(dto);

    //     ApiResponse<String> response = new ApiResponse<>();
    //     response.setStatus("success");
    //     response.setData(token);
    //     response.setMessage("Login realizado com sucesso");

    //     return ResponseEntity.ok(response);
    // }
}
