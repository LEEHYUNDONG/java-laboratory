package com.example.java.practice.ratelimiter.infrastructure.config;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ApiFlowControlConfig {

    @Bean
    public RateLimiterRegistry rateLimiterRegistry() {
        RateLimiterConfig config = RateLimiterConfig
                .custom()
                .limitForPeriod(5)
                .limitRefreshPeriod(Duration.ofMillis(100))
                .timeoutDuration(Duration.ofMillis(1000))
                .build();
        return RateLimiterRegistry.of(config);
    }

    @Bean
    public RateLimiter testRateLimiter(RateLimiterRegistry rateLimiterRegistry) {
        return rateLimiterRegistry.rateLimiter("testRateLimiter");
    }
}
