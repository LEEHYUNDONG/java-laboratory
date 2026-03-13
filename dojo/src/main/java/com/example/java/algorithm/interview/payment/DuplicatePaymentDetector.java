package com.example.java.algorithm.interview.payment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 문제: 중복 결제 방지 시스템
 *
 * 실무 시나리오:
 * 사용자가 실수로 또는 악의적으로 같은 주문을 여러 번 결제하는 것을 방지하는 시스템을 구현하세요.
 *
 * 중복 결제 판단 기준:
 * - 같은 사용자
 * - 같은 금액
 * - 같은 상품 목록
 * - 특정 시간(5분) 이내
 *
 * 요구사항:
 * 1. 중복 결제 여부를 빠르게 판단해야 함 (O(1) 시간 복잡도)
 * 2. 오래된 결제 정보는 자동으로 제거되어야 함 (메모리 누수 방지)
 * 3. 동시성 문제를 고려해야 함 (Thread-safe)
 *
 * 예시:
 * Payment1: userId=123, amount=10000, products=[A,B], time=10:00
 * Payment2: userId=123, amount=10000, products=[A,B], time=10:03 -> 중복!
 * Payment3: userId=123, amount=10000, products=[A,B], time=10:06 -> 허용 (5분 경과)
 */
public class DuplicatePaymentDetector {

    public static class PaymentAttempt {
        private final String userId;
        private final int amount;
        private final List<String> productIds;
        private final LocalDateTime attemptTime;

        public PaymentAttempt(String userId, int amount, List<String> productIds, LocalDateTime attemptTime) {
            this.userId = userId;
            this.amount = amount;
            this.productIds = new ArrayList<>(productIds);
            this.attemptTime = attemptTime;
        }

        public String getUserId() {
            return userId;
        }

        public int getAmount() {
            return amount;
        }

        public List<String> getProductIds() {
            return new ArrayList<>(productIds);
        }

        public LocalDateTime getAttemptTime() {
            return attemptTime;
        }

        /**
         * 비즈니스 키 생성 (userId + amount + sorted productIds)
         */
        public String generateKey() {
            List<String> sortedProducts = new ArrayList<>(productIds);
            Collections.sort(sortedProducts);
            return userId + ":" + amount + ":" + String.join(",", sortedProducts);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PaymentAttempt that = (PaymentAttempt) o;
            return amount == that.amount &&
                   Objects.equals(userId, that.userId) &&
                   Objects.equals(new HashSet<>(productIds), new HashSet<>(that.productIds));
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId, amount, new HashSet<>(productIds));
        }
    }

    private static final Duration DUPLICATE_CHECK_WINDOW = Duration.ofMinutes(5);

    // Key: 비즈니스 키, Value: 최근 결제 시도 시간
    private final Map<String, LocalDateTime> recentPayments = new ConcurrentHashMap<>();

    /**
     * 중복 결제 시도인지 확인합니다.
     * @return true if duplicate, false if allowed
     */
    public boolean isDuplicate(PaymentAttempt attempt) {
        // TODO: 구현하세요
        // 힌트:
        // 1. attempt에서 비즈니스 키 생성
        // 2. 최근 결제 이력 확인
        // 3. 시간 윈도우 체크
        // 4. 중복이 아니면 새로운 시도로 기록
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 오래된 결제 정보를 제거합니다. (메모리 관리)
     */
    public void cleanupOldRecords(LocalDateTime currentTime) {
        // TODO: 구현하세요
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // 정답 (참고용)
    public boolean isDuplicateSolution(PaymentAttempt attempt) {
        String key = attempt.generateKey();
        LocalDateTime now = attempt.getAttemptTime();

        // 이전 결제 시도 확인
        LocalDateTime lastAttemptTime = recentPayments.get(key);

        if (lastAttemptTime != null) {
            Duration timeDiff = Duration.between(lastAttemptTime, now);

            // 시간 윈도우 내의 중복 결제
            if (timeDiff.compareTo(DUPLICATE_CHECK_WINDOW) < 0) {
                return true; // 중복!
            }
        }

        // 새로운 결제 시도로 기록
        recentPayments.put(key, now);
        return false; // 허용
    }

    public void cleanupOldRecordsSolution(LocalDateTime currentTime) {
        recentPayments.entrySet().removeIf(entry -> {
            Duration age = Duration.between(entry.getValue(), currentTime);
            return age.compareTo(DUPLICATE_CHECK_WINDOW) >= 0;
        });
    }

    /**
     * 테스트용: 저장된 레코드 수 반환
     */
    public int getRecordCount() {
        return recentPayments.size();
    }

    /**
     * 테스트용: 모든 레코드 초기화
     */
    public void clear() {
        recentPayments.clear();
    }
}
