package com.example.api_integration.service;

import com.example.api_integration.dto.PaymentRequest;
import com.example.api_integration.dto.RefundRequest;
import com.example.api_integration.dto.PaymentStatusResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class PaymentIntegrationServiceImpl implements PaymentIntegrationService {

    private final RestTemplate restTemplate;
    private final String paymentProviderBaseUrl;

    // In-memory storage for demo purposes
    private final Map<String, PaymentStatusResponse> paymentStore = new ConcurrentHashMap<>();

    public PaymentIntegrationServiceImpl(RestTemplate restTemplate,
                                         @Value("${payment.provider.base-url}") String paymentProviderBaseUrl) {
        this.restTemplate = restTemplate;
        this.paymentProviderBaseUrl = paymentProviderBaseUrl;
    }

    @Override
    public PaymentStatusResponse processPayment(PaymentRequest request) {
        log.info("Processing payment: {}", request);
        String transactionId = UUID.randomUUID().toString();
        PaymentStatusResponse response = new PaymentStatusResponse();
        response.setTransactionId(transactionId);
        response.setStatus("SUCCESS");
        response.setMessage("Payment processed successfully");
        paymentStore.put(transactionId, response);
        return response;
    }

    @Override
    public PaymentStatusResponse refundPayment(RefundRequest request) {
        log.info("Refunding payment: {}", request);
        PaymentStatusResponse existing = paymentStore.get(request.getTransactionId());
        if (existing != null && "SUCCESS".equalsIgnoreCase(existing.getStatus())) {
            existing.setStatus("REFUNDED");
            existing.setMessage("Payment refunded successfully");
            return existing;
        } else {
            PaymentStatusResponse errorResponse = new PaymentStatusResponse();
            errorResponse.setTransactionId(request.getTransactionId());
            errorResponse.setStatus("FAILED");
            errorResponse.setMessage("Refund failed: Transaction not found or not successful");
            return errorResponse;
        }
    }

    @Override
    public PaymentStatusResponse checkPaymentStatus(String transactionId) {
        log.info("Checking payment status for transactionId: {}", transactionId);
        PaymentStatusResponse response = paymentStore.get(transactionId);
        if (response != null) {
            return response;
        } else {
            PaymentStatusResponse errorResponse = new PaymentStatusResponse();
            errorResponse.setTransactionId(transactionId);
            errorResponse.setStatus("FAILED");
            errorResponse.setMessage("Transaction not found");
            return errorResponse;
        }
    }

    @Override
    public List<PaymentStatusResponse> getAllPayments() {
        return List.copyOf(paymentStore.values());
    }
}
