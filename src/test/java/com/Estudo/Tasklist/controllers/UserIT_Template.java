package com.Estudo.Tasklist.controllers;

import com.Estudo.Tasklist.dtos.auth.RegistrationDto;
import com.Estudo.Tasklist.dtos.responses.ApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIT_Template {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Deve cadastrar usuário com sucesso")
    void CreateUser() {
        RegistrationDto dto = new RegistrationDto();
        dto.setName("Teste");
        dto.setEmail("example@gmail.com");
        dto.setPassword("senha123");

        ResponseEntity<ApiResponse> response = restTemplate.postForEntity(
                "/users/registration", dto, ApiResponse.class);


        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

        ApiResponse body = response.getBody();
        Assertions.assertNotNull(body);
        Assertions.assertEquals("success", body.getStatus());
        Assertions.assertEquals("Usuário criado com sucesso", body.getMessage());
    }

    @Test
    @DisplayName("Deve retornar erro ao cadastrar sem email")
    void CreateWithInvalidEmail() {
        RegistrationDto dto = new RegistrationDto();
        dto.setName("Teste");
        dto.setPassword("senha123");

        ResponseEntity<String> response = restTemplate.postForEntity(
                "/users/registration", dto, String.class);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
