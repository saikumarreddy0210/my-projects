# Project Title
External API Integration Service

# Tech Stack
- Java 21
- Spring Boot (latest version)
- Spring Web
- Spring Boot Actuator
- Lombok
- Jackson for JSON parsing
- SLF4J/Logback for logging
- Optional: Spring Retry for retry logic
- Optional: Resilience4j for resilience and circuit breaking

# Description
Build a Spring Boot RESTful service that integrates with a third-party payment provider API.  
The service must handle payment processing, refunds, and payment status checks.  
It should include proper HTTP client configuration, error handling, and structured logging for audit purposes.

# Requirements
1. **Service Layer**
    - Create a service named `PaymentIntegrationService`.
    - Implement the following methods:
        - `processPayment(PaymentRequest request)` → calls the third-party API to initiate payment.
        - `refundPayment(RefundRequest request)` → calls the API to refund payment.
        - `checkPaymentStatus(String transactionId)` → calls the API to retrieve status.
    - Use `RestTemplate` or `WebClient` for HTTP calls.
    - Configure:
        - Connection timeout
        - Read timeout
        - Retry logic (max 3 retries for transient errors)
    - Map API responses into DTOs (`PaymentResponse`, `RefundResponse`, `StatusResponse`).

2. **Error Handling**
    - Create a custom exception class for API failures: `PaymentApiException`.
    - Handle cases like:
        - API unavailable (503)
        - Unauthorized (401)
        - Invalid request (400)
        - Unknown errors
    - Log all errors with full context (request + response).

3. **Logging**
    - Use SLF4J logging in all methods.
    - Log:
        - Request payload
        - Response payload
        - Errors with stack traces
        - Retry attempts
    - Ensure logs are structured for easy searching.

4. **Configuration**
    - Externalize API base URL, API key, and timeout settings in `application.yml`.
    - Use `@ConfigurationProperties` to load settings.

5. **Controller Layer**
    - Create REST endpoints:
        - `POST /api/payments` → calls `processPayment`
        - `POST /api/payments/refund` → calls `refundPayment`
        - `GET /api/payments/{transactionId}` → calls `checkPaymentStatus`
    - Return proper HTTP status codes and JSON responses.

6. **Evaluation Points**
    - HTTP client configuration correctness
    - Resilience and retry logic
    - Accurate response mapping
    - Comprehensive error handling
    - Logging quality for audit trails

# Deliverables
- `pom.xml` with required dependencies
- `application.yml` with placeholders for API config
- DTO classes (`PaymentRequest`, `PaymentResponse`, etc.)
- `PaymentIntegrationService` implementation
- Controller exposing the endpoints
- Custom exception handling with `@ControllerAdvice`
- Unit tests for the service layer with mocked HTTP calls
