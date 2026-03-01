package com.example.java.practice.ratelimiter.controller;

import com.example.java.practice.ratelimiter.service.RateLimiterTestService;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rate-limiter")
public class TestController {

    private final RateLimiterTestService rateLimiterTestService;

    @GetMapping("/test")
    public ResponseEntity<String> testRateLimit() {
        try {
            String result = rateLimiterTestService.executeWithRateLimit();
            return ResponseEntity.ok(result);
        } catch (RequestNotPermitted e) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body("Rate limit exceeded. Please try again later.");
        }
    }

    @GetMapping("/status")
    public ResponseEntity<String> getRateLimiterStatus() {
        return ResponseEntity.ok(rateLimiterTestService.getRateLimiterStatus());
    }
}
