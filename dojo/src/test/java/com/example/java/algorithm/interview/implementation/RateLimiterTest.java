package com.example.java.algorithm.interview.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Rate Limiter 테스트")
class RateLimiterTest {

    private RateLimiter rateLimiter;
    private LocalDateTime baseTime;

    @BeforeEach
    void setUp() {
        rateLimiter = new RateLimiter(3, Duration.ofSeconds(10));
        baseTime = LocalDateTime.of(2024, 1, 1, 10, 0, 0);
    }

    @Test
    @DisplayName("제한 내 요청 허용")
    void testAllowRequestsWithinLimit() {
        assertThat(rateLimiter.allowRequest("user1", baseTime)).isTrue();
        assertThat(rateLimiter.allowRequest("user1", baseTime.plusSeconds(1))).isTrue();
        assertThat(rateLimiter.allowRequest("user1", baseTime.plusSeconds(2))).isTrue();
    }

    @Test
    @DisplayName("제한 초과 요청 거부")
    void testRejectRequestsExceedingLimit() {
        rateLimiter.allowRequest("user1", baseTime);
        rateLimiter.allowRequest("user1", baseTime.plusSeconds(1));
        rateLimiter.allowRequest("user1", baseTime.plusSeconds(2));

        assertThat(rateLimiter.allowRequest("user1", baseTime.plusSeconds(3))).isFalse();
    }

    @Test
    @DisplayName("슬라이딩 윈도우 - 오래된 요청 제거 후 허용")
    void testSlidingWindow() {
        rateLimiter.allowRequest("user1", baseTime);
        rateLimiter.allowRequest("user1", baseTime.plusSeconds(1));
        rateLimiter.allowRequest("user1", baseTime.plusSeconds(2));
        assertThat(rateLimiter.allowRequest("user1", baseTime.plusSeconds(3))).isFalse();

        // 첫 요청이 윈도우 밖으로 나감 (10초 경과)
        assertThat(rateLimiter.allowRequest("user1", baseTime.plusSeconds(11))).isTrue();
    }

    @Test
    @DisplayName("현재 요청 카운트 조회")
    void testGetCurrentRequestCount() {
        rateLimiter.allowRequest("user1", baseTime);
        rateLimiter.allowRequest("user1", baseTime.plusSeconds(1));

        assertThat(rateLimiter.getCurrentRequestCountSolution("user1")).isEqualTo(2);
    }

    @Test
    @DisplayName("사용자별 독립적인 제한")
    void testIndependentUserLimits() {
        rateLimiter.allowRequest("user1", baseTime);
        rateLimiter.allowRequest("user1", baseTime.plusSeconds(1));
        rateLimiter.allowRequest("user1", baseTime.plusSeconds(2));

        // user2는 독립적으로 동작
        assertThat(rateLimiter.allowRequest("user2", baseTime)).isTrue();
    }

    @Test
    @DisplayName("등록되지 않은 사용자 요청 카운트 0")
    void testUnknownUserRequestCount() {
        assertThat(rateLimiter.getCurrentRequestCountSolution("unknown")).isEqualTo(0);
    }

    @Test
    @DisplayName("윈도우 경계 테스트")
    void testWindowBoundary() {
        rateLimiter.allowRequest("user1", baseTime);
        rateLimiter.allowRequest("user1", baseTime.plusSeconds(5));
        rateLimiter.allowRequest("user1", baseTime.plusSeconds(9));

        // 10초 경과 직전
        assertThat(rateLimiter.allowRequest("user1", baseTime.plusSeconds(9).plusNanos(999_999_999))).isFalse();

        // 10초보다 약간 더 경과 (첫 요청이 윈도우 밖)
        assertThat(rateLimiter.allowRequest("user1", baseTime.plusSeconds(10).plusNanos(1))).isTrue();
    }

    @Test
    @DisplayName("연속적인 슬라이딩 윈도우 테스트")
    void testContinuousSlidingWindow() {
        rateLimiter.allowRequest("user1", baseTime);                  // t=0
        rateLimiter.allowRequest("user1", baseTime.plusSeconds(1));   // t=1
        rateLimiter.allowRequest("user1", baseTime.plusSeconds(2));   // t=2
        assertThat(rateLimiter.allowRequest("user1", baseTime.plusSeconds(10))).isFalse(); // t=10, window [0-10]

        rateLimiter.allowRequest("user1", baseTime.plusSeconds(11));  // t=11, window [1-11], t=0 제거
        assertThat(rateLimiter.getCurrentRequestCountSolution("user1")).isEqualTo(3); // t=1,2,11

        rateLimiter.allowRequest("user1", baseTime.plusSeconds(12));  // t=12, window [2-12], t=1 제거
        assertThat(rateLimiter.getCurrentRequestCountSolution("user1")).isEqualTo(3); // t=2,11,12
    }

    @Test
    @DisplayName("clear 메서드 테스트")
    void testClear() {
        rateLimiter.allowRequest("user1", baseTime);
        rateLimiter.allowRequest("user2", baseTime);

        rateLimiter.clear();

        assertThat(rateLimiter.getCurrentRequestCountSolution("user1")).isEqualTo(0);
        assertThat(rateLimiter.getCurrentRequestCountSolution("user2")).isEqualTo(0);
    }

    @Test
    @DisplayName("매우 짧은 윈도우 테스트")
    void testVeryShortWindow() {
        RateLimiter shortLimiter = new RateLimiter(2, Duration.ofMillis(100));

        assertThat(shortLimiter.allowRequest("user1", baseTime)).isTrue();
        assertThat(shortLimiter.allowRequest("user1", baseTime.plusNanos(50_000_000))).isTrue();
        assertThat(shortLimiter.allowRequest("user1", baseTime.plusNanos(60_000_000))).isFalse();
        assertThat(shortLimiter.allowRequest("user1", baseTime.plusNanos(110_000_000))).isTrue();
    }

    @Test
    @DisplayName("제한 1개 테스트")
    void testSingleRequestLimit() {
        RateLimiter singleLimiter = new RateLimiter(1, Duration.ofSeconds(5));

        assertThat(singleLimiter.allowRequest("user1", baseTime)).isTrue();
        assertThat(singleLimiter.allowRequest("user1", baseTime.plusSeconds(1))).isFalse();
        assertThat(singleLimiter.allowRequest("user1", baseTime.plusSeconds(6))).isTrue();
    }

    @Test
    @DisplayName("동시 요청 처리 - Thread Safety")
    void testConcurrentRequests() throws InterruptedException {
        RateLimiter limiter = new RateLimiter(10, Duration.ofSeconds(1));
        int threadCount = 20;
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(threadCount);
        java.util.concurrent.atomic.AtomicInteger successCount = new java.util.concurrent.atomic.AtomicInteger(0);
        LocalDateTime requestTime = LocalDateTime.now();

        java.util.List<Thread> threads = new java.util.ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                try {
                    latch.countDown();
                    latch.await();  // 모든 스레드가 동시에 시작
                    if (limiter.allowRequest("user1", requestTime)) {
                        successCount.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        // 정확히 10개만 허용되어야 함 (maxRequests = 10)
        assertThat(successCount.get()).isEqualTo(10);
    }

    @Test
    @DisplayName("여러 사용자 동시 요청 - 독립성 보장")
    void testConcurrentRequestsMultipleUsers() throws InterruptedException {
        RateLimiter limiter = new RateLimiter(5, Duration.ofSeconds(1));
        int usersCount = 5;
        int requestsPerUser = 10;
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(usersCount * requestsPerUser);
        java.util.Map<String, java.util.concurrent.atomic.AtomicInteger> successCounts = new java.util.concurrent.ConcurrentHashMap<>();
        LocalDateTime requestTime = LocalDateTime.now();

        java.util.List<Thread> threads = new java.util.ArrayList<>();
        for (int userId = 0; userId < usersCount; userId++) {
            String user = "user" + userId;
            successCounts.put(user, new java.util.concurrent.atomic.AtomicInteger(0));

            for (int req = 0; req < requestsPerUser; req++) {
                Thread thread = new Thread(() -> {
                    try {
                        latch.countDown();
                        latch.await();
                        if (limiter.allowRequest(user, requestTime)) {
                            successCounts.get(user).incrementAndGet();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
                threads.add(thread);
                thread.start();
            }
        }

        for (Thread thread : threads) {
            thread.join();
        }

        // 각 사용자마다 정확히 5개씩 허용되어야 함
        for (String user : successCounts.keySet()) {
            assertThat(successCounts.get(user).get())
                .as("User %s should have exactly 5 allowed requests", user)
                .isEqualTo(5);
        }
    }
}
