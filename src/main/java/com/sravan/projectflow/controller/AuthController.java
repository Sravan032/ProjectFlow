package com.sravan.ProjectFlow.controller;

import com.sravan.ProjectFlow.dto.AuthResponse;
import com.sravan.ProjectFlow.dto.LoginRequest;
import com.sravan.ProjectFlow.dto.RegisterRequest;
import com.sravan.ProjectFlow.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {

        return authService.login(request);
    }
}

