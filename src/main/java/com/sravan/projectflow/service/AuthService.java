package com.sravan.ProjectFlow.service;

import com.sravan.ProjectFlow.dto.AuthResponse;
import com.sravan.ProjectFlow.dto.LoginRequest;
import com.sravan.ProjectFlow.dto.RegisterRequest;
import com.sravan.ProjectFlow.entity.User;
import com.sravan.ProjectFlow.enums.Role;
import com.sravan.ProjectFlow.repository.UserRepository;
import com.sravan.ProjectFlow.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private JwtUtil jwtUtil = new JwtUtil();


    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole(Role.USER);

        userRepository.save(user);

        return "User registered successfully";
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password")
                );

        boolean isPasswordValid = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!isPasswordValid) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token);
    }
}
