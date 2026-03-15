package com.example.java.algorithm.interview.implementation;

import com.google.common.util.concurrent.Striped;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

/**
 * 문제: API Rate Limiter (요청 제한기)
 *
 * 실무 시나리오:
 * API 서버에서 사용자별로 요청 횟수를 제한하는 Rate Limiter를 구현하세요.
 * 예: 1분에 최대 10개의 요청만 허용
 *
 * 요구사항:
 * 1. 사용자별로 독립적인 제한 적용
 * 2. 슬라이딩 윈도우 방식 사용 (고정 윈도우가 아님)
 * 3. 동시성 안전 (Thread-safe)
 * 4. 메모리 효율적 (오래된 기록 자동 정리)
 *
 * 제약사항:
 * - allowRequest() 메서드는 O(n) 시간 복잡도 (n = 윈도우 내 요청 수)
 * - 각 사용자의 요청 기록은 Queue로 관리
 *
 * 예시:
 * RateLimiter limiter = new RateLimiter(3, Duration.ofSeconds(10));
 * limiter.allowRequest("user1", now);     // true (1/3)
 * limiter.allowRequest("user1", now + 1s); // true (2/3)
 * limiter.allowRequest("user1", now + 2s); // true (3/3)
 * limiter.allowRequest("user1", now + 3s); // false (초과!)
 * limiter.allowRequest("user1", now + 11s); // true (첫 요청이 윈도우 밖으로 나감)
 */
public class RateLimiter {

    private final int maxRequests;
    private final Duration timeWindow;
    private final Map<String, Queue<LocalDateTime>> userRequestHistory;
    // Striped Lock: 128개의 lock stripe를 생성하여 userId 해시로 분산
    // 서로 다른 사용자는 다른 lock을 사용할 확률이 높아 동시성 향상
    private final Striped<Lock> stripedLock = Striped.lock(128);

    public RateLimiter(int maxRequests, Duration timeWindow) {
        this.maxRequests = maxRequests;
        this.timeWindow = timeWindow;
        this.userRequestHistory = new ConcurrentHashMap<>();
    }

    /**
     * 요청 허용 여부를 판단합니다.
     *
     * @param userId 사용자 ID
     * @param requestTime 요청 시간
     * @return true if allowed, false if rate limit exceeded
     */
    public boolean allowRequest(String userId, LocalDateTime requestTime) {
        // userId를 기반으로 stripe에서 lock 획득
        // 같은 userId는 항상 같은 lock을 받지만, 다른 userId는 다른 lock을 받을 확률이 높음
        Lock lock = stripedLock.get(userId);

        // Lock으로 보호하므로 일반 ArrayDeque 사용 (더 빠르고 메모리 효율적)
        Queue<LocalDateTime> requests = userRequestHistory.computeIfAbsent(
            userId, k -> new ArrayDeque<>()
        );

        lock.lock();
        try {
            // 시간 윈도우를 벗어난 오래된 요청 제거
            LocalDateTime windowStart = requestTime.minus(timeWindow);
            while (!requests.isEmpty() && requests.peek().isBefore(windowStart)) {
                requests.poll();
            }

            // 요청 수 확인 및 추가 (atomic하게 처리)
            if (requests.size() < maxRequests) {
                requests.offer(requestTime);
                return true;
            }

            return false;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 사용자의 현재 요청 카운트를 반환합니다.
     */
    public int getCurrentRequestCount(String userId) {
        Queue<LocalDateTime> requests = userRequestHistory.get(userId);
        return requests == null ? 0 : requests.size();
    }

    /**
     * 테스트용: 모든 기록 초기화
     */
    public void clear() {
        userRequestHistory.clear();
    }

    // ========== 정답 (참고용) ==========

    public boolean allowRequestSolution(String userId, LocalDateTime requestTime) {
        Queue<LocalDateTime> requests = userRequestHistory.computeIfAbsent(
            userId, k -> new LinkedList<>()
        );

        // 시간 윈도우를 벗어난 오래된 요청 제거
        LocalDateTime windowStart = requestTime.minus(timeWindow);
        while (!requests.isEmpty() && requests.peek().isBefore(windowStart)) {
            requests.poll();
        }

        // 요청 수 확인
        if (requests.size() < maxRequests) {
            requests.offer(requestTime);
            return true;
        }

        return false;
    }

    public int getCurrentRequestCountSolution(String userId) {
        Queue<LocalDateTime> requests = userRequestHistory.get(userId);
        return requests == null ? 0 : requests.size();
    }
}
