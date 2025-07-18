package com.enaa.authservice.service;

import com.enaa.authservice.DTO.AuthDTOs;
import com.enaa.authservice.Repository.UserRepository;

import com.enaa.authservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtService jwtService;
    private User user;

    public AuthService(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
    }

    public AuthDTOs.AuthResponse register(AuthDTOs.RegisterRequest request) {
         user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return new AuthDTOs.AuthResponse(token);
    }

    public AuthDTOs.AuthResponse login(AuthDTOs.LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user);
        return new AuthDTOs.AuthResponse(token);
    }
}
