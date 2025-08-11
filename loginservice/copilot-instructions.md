# Project Goal

Create a Spring Boot application in Java 21 to implement a secure login service with JWT-based authentication and role-based authorization.

---

# Features to Implement

## Authentication Service Layer
1. `login(String username, String password)`: Authenticates the user and returns a JWT token.
2. `logout(String token)`: Invalidates the token or manages logout (JWT stateless – clear from frontend or maintain blacklist if needed).
3. `validateToken(String token)`: Verifies JWT and extracts user details.

## Authorization
- Use Spring Security to restrict access to endpoints based on user roles (e.g., `ROLE_ADMIN`, `ROLE_USER`).
- Configure protected endpoints in `SecurityConfig`.

## Exception Handling
- Handle exceptions like:
    - `BadCredentialsException`
    - `UsernameNotFoundException`
    - `JwtException` (expired or invalid token)
- Use a global exception handler with `@ControllerAdvice`.

## Clean Code Structure
- Organize into proper layers:
    - `controller`
    - `service`
    - `repository`
    - `security` (JWT utils, filters, config)
    - `model` (entities, DTOs)
    - `exception`

## Security Best Practices
- Passwords should be stored securely using BCrypt.
- JWT secret should come from `application.properties` and not hardcoded.
- Token expiration must be handled.
- Use `UserDetailsService` and `AuthenticationManager`.

---

# Technologies & Dependencies

- Java 21
- Spring Boot (Latest)
- Spring Security
- JWT (JJWT or equivalent)
- Lombok
- Jakarta Annotations
- Maven or Gradle
- No database (optional in-memory user store or hardcoded users)

---

# Expected Endpoints

| Method | Endpoint         | Description                  | Access Role      |
|--------|------------------|------------------------------|------------------|
| POST   | `/auth/login`    | Authenticate user            | Public           |
| POST   | `/auth/logout`   | Log out user (optional impl) | Authenticated    |
| GET    | `/auth/validate` | Validate token               | Authenticated    |
| GET    | `/admin/data`    | Admin-only resource          | ROLE_ADMIN only  |
| GET    | `/user/data`     | User-only resource           | ROLE_USER only   |

---

# Example Classes to Generate

- `AuthController`
- `AuthService`
- `JwtTokenProvider`
- `SecurityConfig`
- `UserDetailsServiceImpl`
- `CustomUser` (implements `UserDetails`)
- `JwtAuthenticationFilter`
- `GlobalExceptionHandler`

---

# Additional Notes

- Use annotations like `@RestController`, `@Service`, `@Component`, `@Slf4j`, `@PostConstruct` appropriately.
- Prefer constructor injection over field injection.
- Ensure token claims like `username` and `role` are properly set and extracted.

