package com.sravan.ProjectFlow.controller;

import com.sravan.ProjectFlow.dto.UserInfoResponse;
import com.sravan.ProjectFlow.entity.User;

import com.sravan.ProjectFlow.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    public UserInfoResponse getCurrentUser(
            Authentication authentication
    ) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );

        return new UserInfoResponse(
                user.getEmail(),
                user.getRole().name()
        );
    }
}