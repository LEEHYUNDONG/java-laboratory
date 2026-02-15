package com.example.java.work.practice.ratelimiter.service;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@Slf4j
@Service
@RequiredArgsConstructor
public class RateLimiterTestService {

    private final RateLimiter testRateLimiter;
    private final AtomicInteger requestCount = new AtomicInteger(0);

    public String executeWithRateLimit() {
        Supplier<String> decoratedSupplier = RateLimiter.decorateSupplier(
                testRateLimiter,
                this::processRequest
        );

        try {
            return decoratedSupplier.get();
        } catch (RequestNotPermitted e) {
            log.warn("Rate limit exceeded for request #{}", requestCount.get());
            throw e;
        }
    }

    private String processRequest() {
        int count = requestCount.incrementAndGet();
        log.info("Processing request #{}", count);
        return "Request #" + count + " processed successfully";
    }

    public String getRateLimiterStatus() {
        return String.format(
                "RateLimiter Status - Available Permits: %d, Number of Waiting Threads: %d",
                testRateLimiter.getMetrics().getAvailablePermissions(),
                testRateLimiter.getMetrics().getNumberOfWaitingThreads()
        );
    }
}
