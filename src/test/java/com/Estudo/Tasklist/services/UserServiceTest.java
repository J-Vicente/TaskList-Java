package com.Estudo.Tasklist.services;

import com.Estudo.Tasklist.dtos.auth.RegistrationDto;
import com.Estudo.Tasklist.dtos.auth.UserDto;
import com.Estudo.Tasklist.entities.User;
import com.Estudo.Tasklist.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userService).build();
    }

    @Test
    @DisplayName("Deve retornar um UserDto")
    public void register() {
        User user = new User("Teste", "example@gmail.com", "senha123");
        RegistrationDto userDto = new RegistrationDto(user);
        UserDto response = userService.register(userDto);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(userDto.getEmail(), response.getEmail());
        Assertions.assertEquals(userDto.getName(), response.getName());

    }
}