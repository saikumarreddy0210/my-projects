# Project Title
Generic Global Exception Handling for Spring Boot Web Application

# Tech Stack
- Java 21
- Spring Boot (latest stable version)
- Spring Web
- Spring Boot Validation
- Lombok
- SLF4J/Logback for logging
- JUnit + Mockito for testing

# Description
Build a Spring Boot REST API with a centralized exception handling mechanism.
The handler must catch various types of exceptions, map them to appropriate HTTP status codes,
log them for debugging, and return a consistent error response format for all failures.

# Requirements

1. **Global Exception Handler**
    - Use `@RestControllerAdvice` to create a centralized exception handler class.
    - Implement `@ExceptionHandler` methods for:
        - `MethodArgumentNotValidException` → HTTP 400 (Validation errors)
        - `BusinessException` (custom) → HTTP 422 (Business rule violations)
        - `ResourceNotFoundException` (custom) → HTTP 404
        - `HttpRequestMethodNotSupportedException` → HTTP 405
        - `Exception` (generic fallback) → HTTP 500

2. **Consistent Error Response**
    - Create an `ErrorResponse` DTO with fields:
        - `timestamp` (ISO 8601 format)
        - `status` (HTTP status code)
        - `error` (short title, e.g., "Validation Error")
        - `message` (user-friendly message)
        - `details` (optional extra info, e.g., field errors)
    - Ensure all exceptions return this format.

3. **Custom Exceptions**
    - Create `BusinessException` and `ResourceNotFoundException` in a structured package (e.g., `com.example.exception`).
    - Both should extend `RuntimeException`.

4. **Validation Handling**
    - Use `javax.validation` annotations in DTOs (e.g., `@NotBlank`, `@Email`, `@Min`).
    - Capture field-level errors from `MethodArgumentNotValidException` and return them in `details`.

5. **Logging**
    - Log all exceptions with:
        - Exception type
        - Message
        - Stack trace for debugging
    - Use `Slf4j` via Lombok `@Slf4j`.

6. **Controller Example**
    - Create a simple REST controller with endpoints that can trigger:
        - Validation errors
        - BusinessException
        - ResourceNotFoundException
    - Example: `POST /api/users` for validation, `GET /api/users/{id}` for resource lookup.

7. **Evaluation Points**
    - Proper use of Spring's exception handling annotations.
    - Clear exception hierarchy and mapping to HTTP status codes.
    - Consistent and user-friendly error response.
    - Adequate logging for debugging and monitoring.
    - Unit tests for exception handling.

# Deliverables
- `pom.xml` with dependencies for Spring Boot Web, Validation, Lombok, and testing.
- Global exception handler class in `com.example.exception`.
- Custom exceptions.
- ErrorResponse DTO.
- Sample controller with endpoints for testing exception handling.
- Unit tests for the exception handler.
