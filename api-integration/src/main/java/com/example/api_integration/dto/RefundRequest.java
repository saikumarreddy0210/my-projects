package com.example.api_integration.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class RefundRequest {
    private String transactionId;
    private BigDecimal amount;
    private String reason;
}

