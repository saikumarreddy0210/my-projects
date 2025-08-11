package com.example.generic_api_response.exception;

import com.example.generic_api_response.response.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {
    @Test
    void handleAllExceptionsShouldReturnErrorResponse() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        Exception ex = new RuntimeException("Test error");
        WebRequest request = mock(WebRequest.class);
        ResponseEntity<ApiResponse<Object>> responseEntity = handler.handleAllExceptions(ex, request);
        ApiResponse<Object> response = responseEntity.getBody();
        assertNotNull(response);
        assertFalse(response.isSuccess());
        assertEquals("Test error", response.getError());
        assertNotNull(response.getTimestamp());
        assertNotNull(response.getRequestId());
    }
}
