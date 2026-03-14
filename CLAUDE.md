# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java learning repository (`java-laboratory`) organized as a multi-module Gradle project with two main modules:
- **architecture**: Demonstrates architectural patterns (Hexagonal Architecture vs Layered Architecture) using a Spring Boot ads serving system
- **dojo**: Practice code including algorithms, design patterns, Java language features, and various programming challenges

## Build System

**Technology**: Gradle with Java 21

### Common Commands

```bash
# Build entire project
./gradlew build

# Run tests for all modules
./gradlew test

# Run tests for specific module
./gradlew :architecture:test
./gradlew :dojo:test

# Run single test class
./gradlew :dojo:test --tests "com.example.java.practice.cache.service.ProductServiceTest"

# Clean build
./gradlew clean build
```

## Architecture Module

Demonstrates two architectural patterns for an ad-serving system:

### Hexagonal Architecture (Port-Adapter Pattern)

Located under `architecture/src/main/java/com/easttwave/pr/architecture/hexagonal/`

**Core Principle**: Business logic (domain + application) is isolated from external concerns through ports and adapters.

**Structure**:
```
hexagonal/ads/
├── management/         # Ad creation and management bounded context
│   ├── ad/
│   │   ├── domain/           # Business entities (Ad, AdId, ImageUri)
│   │   ├── application/
│   │   │   ├── port/
│   │   │   │   ├── in/       # Use cases (AdUsecase)
│   │   │   │   └── out/      # Repository interfaces (AdPersistencePort)
│   │   │   └── service/      # Business logic (AdService)
│   │   └── adapter/
│   │       ├── in/
│   │       │   └── api/      # REST controllers
│   │       └── out/
│   │           └── persistence/  # JPA implementations
│   └── campaign/
├── serving/            # Ad serving to end users bounded context
│   └── (similar structure)
├── tracking/           # Ad tracking events bounded context
│   └── (similar structure)
└── shared/            # Shared infrastructure (JPA config, messaging)
```

**Key Pattern**:
- Domain layer is pure business logic with no external dependencies
- Application layer defines ports (interfaces) for what it needs
- Adapters implement ports to connect to external systems (DB, REST, Redis, SQS)
- Dependencies point inward: Adapters depend on ports, never the reverse

### Layered Architecture

Located under `architecture/src/main/java/com/easttwave/pr/architecture/layered/`

**Structure**: Traditional Controller → Service → Repository layers where Service directly depends on infrastructure concerns (e.g., `RedisTemplate` in `ServableAdService.java:15`).

**Purpose**: Provides contrast to show limitations of layered architecture when infrastructure needs change.

### Architecture Module Dependencies

- Spring Boot 3.1.3
- Spring Data JPA (with H2)
- Spring Data Redis
- SpringDoc OpenAPI
- p6spy (SQL logging)

## Dojo Module

Practice and learning code organized by topic:

### Main Categories

**algorithm/**: Algorithm practice and interview problems
- `dfs/`, `recursive/`: Tree/graph traversal algorithms
- `leetcode/`: LeetCode problem solutions
- `string/`: String manipulation algorithms
- `interview/payment/`: Interview-style coding problems (e.g., DuplicatePaymentDetector)

**designpattern/**: Gang of Four design patterns with examples
- `_01_singleton/`, `_02_factorymethod/`, `_03_composite/` etc.
- Each pattern includes before/after examples and docs.md

**effectivejava/**: Examples from Effective Java book
- Organized by item number (e.g., `item02/` for Builder pattern)

**lang/**: Java language features and advanced topics
- `advanced/_1/thread/`: Comprehensive threading examples
  - `cas/`: Compare-and-swap, atomic operations, spin locks
  - `executor/`: Thread pools, futures, rejection policies
  - `sync/`: Synchronization, locks, LockSupport
  - `collection/`: Thread-safe collections
- `advanced/_2/io/`: I/O operations
- `advanced/_3/lambda/`: Lambda expressions
- `basic/`: Core Java concepts (polymorphism, etc.)
- `stream/`, `generic/`: Streams and generics

**practice/**: Practical programming challenges
- `cache/`: Caching system implementation with TTL and concurrency (see README.md)
- `junit/`: Custom JUnit-like framework implementation
- `collections/`: Collection framework practice
- `ratelimiter/`: Rate limiting with Resilience4j
- `aop/`: Aspect-Oriented Programming with proxies
- `masking/`: Data masking with Jackson

### Dojo Module Dependencies

- Spring Boot (web, AOP)
- Jackson for JSON processing
- Resilience4j for rate limiting
- AssertJ for fluent assertions

## Testing

All tests use JUnit 5 (`org.junit.jupiter`). Test files mirror the source structure under `src/test/java/`.

Run tests with descriptive names using `@DisplayName` annotations.

## Code Patterns to Follow

### In Hexagonal Architecture

1. **Domain objects** should be pure Java with no framework dependencies
2. **Use case interfaces** (in `application/port/in/`) define what the application does
3. **Port interfaces** (in `application/port/out/`) define what the application needs from infrastructure
4. **Services** implement use cases and depend only on port interfaces
5. **Adapters** implement ports and handle framework-specific concerns
6. **Value objects** (e.g., `AdId`, `ImageUri`, `DateRange`) encapsulate domain concepts

### General Patterns

- Use records for DTOs and immutable value objects
- Lombok is available for reducing boilerplate (`@Getter`, `@RequiredArgsConstructor`, etc.)
- Follow bounded context separation in architecture module
- Test files include comprehensive test cases with edge cases

## Notes

- Both modules have `bootJar { enabled = false }` - this is a library/practice project, not a runnable application
- The architecture module includes both hexagonal and layered examples for educational comparison
- Design pattern examples include detailed documentation in `docs.md` files
