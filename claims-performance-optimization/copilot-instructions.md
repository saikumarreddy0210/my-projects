# Performance Optimization Challenge - Claims Application

## Scenario:
Our claims application experiences **slow response times** during peak hours. Users complain about **page load delays**.

## Requirements:
1. **Caching Strategies**
    - Implement caching for frequently accessed data (e.g., claims list, reference data).
    - Use Spring Cache abstraction with an in-memory cache (Caffeine) or Redis.
    - Configure cache expiration and size limits.

2. **Pagination & Lazy Loading**
    - Add pagination for endpoints returning large datasets.
    - Use `Pageable` and `Page` in Spring Data JPA.
    - Implement lazy loading for large object relationships to reduce unnecessary data fetching.

3. **Performance Monitoring Endpoints**
    - Expose application performance metrics via `/actuator` endpoints.
    - Enable Micrometer + Prometheus integration for monitoring.
    - Include metrics for:
        - Average request processing time
        - DB query count & execution time
        - Cache hit/miss ratio

## Implementation Guidelines:
- Use **Spring Boot 3.x** (Java 17 or later).
- Include dependencies:
    - Spring Web
    - Spring Data JPA
    - Spring Cache (Caffeine or Redis)
    - Spring Boot Actuator
    - Micrometer (Prometheus)
    - H2 Database (for demo)
- Use a clean package structure:
  com.example.claims
  ├── controller
  ├── service
  ├── repository
  ├── model
  ├── config
  └── metrics
- Follow **clean code** and **best practices**:
- Use DTOs for API responses.
- Write clear Javadoc for service methods.
- Add meaningful log statements.

## Deliverables:
- Fully working Spring Boot application with:
- Caching for frequently accessed endpoints.
- Pagination & lazy loading in data retrieval.
- `/actuator` endpoints for performance metrics.
- Example test cases for caching and pagination logic.

