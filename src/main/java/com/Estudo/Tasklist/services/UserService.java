package com.Estudo.Tasklist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Estudo.Tasklist.auth.JwtUtil;
import com.Estudo.Tasklist.dtos.auth.LoginDto;
import com.Estudo.Tasklist.dtos.auth.RegistrationDto;
import com.Estudo.Tasklist.dtos.auth.UserDto;
import com.Estudo.Tasklist.entities.User;
import com.Estudo.Tasklist.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil JwtUtil;
    
    @Transactional
    public UserDto register(RegistrationDto dto) {
        
        userRepository.findByEmail(dto.getEmail()).ifPresent(u -> {
            throw new RuntimeException("E-mail já cadastrado");
        });

        User user = new User(dto.getName(), dto.getEmail(), dto.getPassword());

        userRepository.save(user);

        return new UserDto(user);
    }

    public UserDto login(LoginDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Senha incorreta");
        }

        // return JwtUtil.generateToken(user);
        return new UserDto(user);
    }
}
