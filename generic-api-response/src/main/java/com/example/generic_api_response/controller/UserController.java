package com.example.generic_api_response.controller;

import com.example.generic_api_response.response.ApiResponse;
import com.example.generic_api_response.response.PaginationMetadata;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/user/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getUser(@PathVariable String id) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "User " + id);
        ApiResponse<Map<String, Object>> response = ApiResponse.<Map<String, Object>>builder()
                .data(user)
                .success(true)
                .timestamp(Instant.now())
                .requestId(UUID.randomUUID().toString())
                .message("User fetched successfully")
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<Map<String, Object>>>> getUsers(@RequestParam(defaultValue = "0") int page,
                                                                           @RequestParam(defaultValue = "5") int size) {
        List<Map<String, Object>> users = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            Map<String, Object> user = new HashMap<>();
            user.put("id", String.valueOf(page * size + i));
            user.put("name", "User " + (page * size + i));
            users.add(user);
        }
        PaginationMetadata pagination = PaginationMetadata.builder()
                .page(page)
                .size(size)
                .totalElements(50)
                .totalPages(10)
                .build();
        ApiResponse<List<Map<String, Object>>> response = ApiResponse.<List<Map<String, Object>>>builder()
                .data(users)
                .success(true)
                .timestamp(Instant.now())
                .requestId(UUID.randomUUID().toString())
                .message("Users fetched successfully")
                .pagination(pagination)
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/user")
    public ResponseEntity<ApiResponse<Void>> createUser(@RequestBody Map<String, Object> user) {
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .timestamp(Instant.now())
                .requestId(UUID.randomUUID().toString())
                .message("User created successfully")
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/error-demo")
    public ResponseEntity<ApiResponse<Void>> errorDemo() {
        throw new RuntimeException("Demo error");
    }
}

