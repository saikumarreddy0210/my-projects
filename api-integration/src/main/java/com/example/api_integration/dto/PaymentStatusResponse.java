package com.example.api_integration.dto;

import lombok.Data;

@Data
public class PaymentStatusResponse {
    private String transactionId;
    private String status;
    private String message;
}

