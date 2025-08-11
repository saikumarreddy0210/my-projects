package com.example.generic_api_response.response;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;

@Data
@Builder
public class ApiResponse<T> {
    private T data;
    private String message;
    private String requestId;
    private Instant timestamp;
    private PaginationMetadata pagination;
    private boolean success;
    private String error;
}
