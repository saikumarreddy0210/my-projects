package com.example.generic_api_response.exception;

import com.example.generic_api_response.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.Instant;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleAllExceptions(Exception ex, WebRequest request) {
        ApiResponse<Object> response = ApiResponse.builder()
                .success(false)
                .error(ex.getMessage())
                .timestamp(Instant.now())
                .requestId(UUID.randomUUID().toString())
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

