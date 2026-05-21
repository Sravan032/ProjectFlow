package com.sravan.ProjectFlow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public org.springframework.web.cors.CorsConfigurationSource
    corsConfigurationSource() {

        CorsConfiguration config =
                new org.springframework.web.cors.CorsConfiguration();

        config.addAllowedOrigin("http://localhost:5173");

        config.addAllowedMethod("*");

        config.addAllowedHeader("*");

        org.springframework.web.cors.UrlBasedCorsConfigurationSource
                source =
                new org.springframework.web.cors.
                        UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http
                    .cors(cors -> {})
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/**",
                                    // SWAGGER
                                    "/v3/api-docs/**",
                                    "/swagger-ui/**",
                                    "/swagger-ui.html").permitAll()
                            .anyRequest().authenticated()
                    );
            return http.build();
    }
}

