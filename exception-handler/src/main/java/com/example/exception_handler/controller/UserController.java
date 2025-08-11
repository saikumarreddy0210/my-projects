package com.example.exception_handler.controller;

import com.example.exception_handler.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody UserRequest request) {
        // Simulate user creation
        return new UserResponse(1L, request.getName());
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        // Simulate not found
        if (id != 1L) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        return new UserResponse(id, "John Doe");
    }

    @Data
    public static class UserRequest {
        @NotBlank(message = "Name is required")
        private String name;
    }

    @Data
    public static class UserResponse {
        private Long id;
        private String name;
        public UserResponse(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}

