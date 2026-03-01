package com.example.java.practice.ratelimiter;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class RateLimitingTest {

    @TestConfiguration
    static class TestRateLimiterConfig {

        @Bean
        @Primary
        public RateLimiterRegistry testRateLimiterRegistry() {
            RateLimiterConfig config = RateLimiterConfig.custom()
                    .limitForPeriod(5)
                    .limitRefreshPeriod(Duration.ofSeconds(10))
                    .timeoutDuration(Duration.ZERO)  // 즉시 실패
                    .build();

            return RateLimiterRegistry.of(config);
        }

        @Bean
        @Primary
        public RateLimiter testRateLimiter(RateLimiterRegistry testRateLimiterRegistry) {
            return testRateLimiterRegistry.rateLimiter("testRateLimiter");
        }
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Rate limit 이내의 요청은 성공한다")
    void requestWithinRateLimit_shouldSucceed() throws Exception {
        for (int i = 0; i < 5; i++) {
            mockMvc.perform(get("/api/rate-limiter/test"))
                    .andExpect(status().isOk());
        }
    }

    @Test
    @DisplayName("Rate limit 초과 시 429 응답을 반환한다")
    void requestExceedingRateLimit_shouldReturn429() throws Exception {
        // 먼저 5개 요청으로 limit 소진
        for (int i = 0; i < 5; i++) {
            mockMvc.perform(get("/api/rate-limiter/test"));
        }

        // 6번째 요청은 429 반환
        mockMvc.perform(get("/api/rate-limiter/test"))
                .andExpect(status().isTooManyRequests());
    }

    @Test
    @DisplayName("동시 요청 시 Rate limit이 정상 동작한다")
    void concurrentRequests_shouldRespectRateLimit() throws Exception {
        int totalRequests = 10;
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(1);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < totalRequests; i++) {
            futures.add(executor.submit(() -> {
                latch.await();
                MvcResult result = mockMvc.perform(get("/api/rate-limiter/test")).andReturn();
                return result.getResponse().getStatus();
            }));
        }

        latch.countDown();

        List<Integer> statusCodes = new ArrayList<>();
        for (Future<Integer> future : futures) {
            statusCodes.add(future.get());
        }

        executor.shutdown();

        long successCount = statusCodes.stream().filter(code -> code == 200).count();
        long rateLimitedCount = statusCodes.stream().filter(code -> code == 429).count();

        // 최대 5개만 성공, 나머지는 429
        assertThat(successCount).isLessThanOrEqualTo(5);
        assertThat(rateLimitedCount).isGreaterThanOrEqualTo(5);
        assertThat(successCount + rateLimitedCount).isEqualTo(totalRequests);
    }

    @Test
    @DisplayName("Rate limiter 상태 조회가 정상 동작한다")
    void getRateLimiterStatus_shouldReturnStatus() throws Exception {
        mockMvc.perform(get("/api/rate-limiter/status"))
                .andExpect(status().isOk());
    }
}
