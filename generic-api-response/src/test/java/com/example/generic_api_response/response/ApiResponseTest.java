package com.example.generic_api_response.response;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class ApiResponseTest {
    @Test
    void builderShouldCreateApiResponse() {
        ApiResponse<String> response = ApiResponse.<String>builder()
                .data("test-data")
                .message("Success")
                .requestId("req-1")
                .timestamp(Instant.now())
                .success(true)
                .build();
        assertEquals("test-data", response.getData());
        assertEquals("Success", response.getMessage());
        assertEquals("req-1", response.getRequestId());
        assertTrue(response.isSuccess());
        assertNull(response.getError());
    }
}
