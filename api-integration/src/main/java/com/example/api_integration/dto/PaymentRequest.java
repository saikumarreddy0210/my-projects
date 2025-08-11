package com.example.api_integration.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class PaymentRequest {
    private String payerId;
    private String payeeId;
    private BigDecimal amount;
    private String currency;
    private String paymentMethod;
}

