package com.example.loginservice.service;

import com.example.loginservice.model.AuthRequest;
import com.example.loginservice.model.AuthResponse;

public interface AuthService {
    AuthResponse login(String username, String password);
    void logout(String token);
    boolean validateToken(String token);
}
