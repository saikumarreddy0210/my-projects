package com.example.api_integration.controller;

import com.example.api_integration.dto.PaymentRequest;
import com.example.api_integration.dto.RefundRequest;
import com.example.api_integration.dto.PaymentStatusResponse;
import com.example.api_integration.service.PaymentIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentIntegrationService paymentIntegrationService;

    @PostMapping
    public ResponseEntity<PaymentStatusResponse> processPayment(@RequestBody PaymentRequest request) {
        PaymentStatusResponse response = paymentIntegrationService.processPayment(request);
        if ("FAILED".equalsIgnoreCase(response.getStatus())) {
            return ResponseEntity.status(502).body(response); // 502 Bad Gateway for external API failure
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refund")
    public ResponseEntity<PaymentStatusResponse> refundPayment(@RequestBody RefundRequest request) {
        PaymentStatusResponse response = paymentIntegrationService.refundPayment(request);
        if ("FAILED".equalsIgnoreCase(response.getStatus())) {
            return ResponseEntity.status(502).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{transactionId}/status")
    public ResponseEntity<PaymentStatusResponse> checkPaymentStatus(@PathVariable String transactionId) {
        PaymentStatusResponse response = paymentIntegrationService.checkPaymentStatus(transactionId);
        if ("FAILED".equalsIgnoreCase(response.getStatus())) {
            return ResponseEntity.status(502).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PaymentStatusResponse>> getAllPayments() {
        return ResponseEntity.ok(paymentIntegrationService.getAllPayments());
    }
}
