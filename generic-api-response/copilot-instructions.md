# Project Title
Generic API Response Wrapper for Spring Boot REST APIs

# Tech Stack
- Java 21
- Spring Boot (latest stable version)
- Spring Web
- Lombok
- Jackson for JSON serialization
- SLF4J/Logback for logging
- JUnit & Mockito for testing

# Description
Build a Spring Boot REST API with a standardized response wrapper that will be used for all API responses (success and error).  
This wrapper should be generic so it can hold any type of data, include metadata like timestamps, request IDs, and pagination details,  
and be easy to construct using the builder pattern.

# Requirements

1. **Generic Response Wrapper**
    - Create a generic class `ApiResponse<T>` with:
        - `timestamp` (ISO 8601 format)
        - `requestId` (String)
        - `status` (String: "SUCCESS" or "ERROR")
        - `errorCode` (String, nullable for success)
        - `message` (String)
        - `data` (Generic type T)
        - `pagination` (optional object with fields: `page`, `size`, `totalElements`, `totalPages`)
    - Implement builder pattern for easy creation.

2. **Usage**
    - In controllers, return `ApiResponse<T>` instead of raw objects.
    - Support:
        - Single object responses
        - Collection responses
        - Primitive type responses

3. **Error Handling**
    - Integrate with a global exception handler (`@RestControllerAdvice`) so all errors are returned in `ApiResponse` format.
    - Include `status = "ERROR"`, `errorCode`, and `message` from exception.

4. **Metadata Handling**
    - Automatically set:
        - `timestamp` (current UTC time in ISO format)
        - `requestId` (generate UUID if not provided)
    - Allow optional pagination info for list responses.

5. **Builder Pattern**
    - Use Lombok `@Builder` or manually implement a builder class to make creating responses concise.

6. **Controller Examples**
    - Provide sample REST endpoints:
        - `GET /api/user/{id}` → returns a single object
        - `GET /api/users` → returns paginated list
        - `POST /api/user` → returns success confirmation
        - An endpoint that triggers an error to demonstrate error response

7. **Evaluation Points**
    - Correct use of Java generics.
    - Builder pattern for cleaner construction.
    - Consistent response format for all endpoints.
    - Metadata completeness (timestamp, request ID, pagination).
    - Integration with global exception handling.

# Deliverables
- `pom.xml` with required dependencies.
- `ApiResponse<T>` class with builder.
- `PaginationMetadata` class for pagination details.
- Global exception handler returning `ApiResponse` for errors.
- Sample controller with endpoints for testing different response types.
- Unit tests for `ApiResponse` and exception handling.
