package com.example.api_integration.service;

import com.example.api_integration.dto.PaymentRequest;
import com.example.api_integration.dto.RefundRequest;
import com.example.api_integration.dto.PaymentStatusResponse;

import java.util.List;

public interface PaymentIntegrationService {
    PaymentStatusResponse processPayment(PaymentRequest request);
    PaymentStatusResponse refundPayment(RefundRequest request);
    PaymentStatusResponse checkPaymentStatus(String transactionId);
    List<PaymentStatusResponse> getAllPayments();
}
