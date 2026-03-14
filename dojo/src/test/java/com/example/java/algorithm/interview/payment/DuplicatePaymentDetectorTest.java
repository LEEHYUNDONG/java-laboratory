package com.example.java.algorithm.interview.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicatePaymentDetectorTest {

    private DuplicatePaymentDetector detector;

    @BeforeEach
    void setUp() {
        detector = new DuplicatePaymentDetector();
    }

    @Test
    @DisplayName("첫 결제 시도는 허용")
    void testFirstAttemptAllowed() {
        LocalDateTime now = LocalDateTime.now();
        DuplicatePaymentDetector.PaymentAttempt attempt = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-A", "PROD-B"),
            now
        );

        boolean isDuplicate = detector.isDuplicate(attempt);

        assertThat(isDuplicate).isFalse();
    }

    @Test
    @DisplayName("5분 이내 같은 결제는 중복으로 판단")
    void testDuplicateWithin5Minutes() {
        LocalDateTime now = LocalDateTime.now();

        DuplicatePaymentDetector.PaymentAttempt attempt1 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-A", "PROD-B"),
            now
        );

        DuplicatePaymentDetector.PaymentAttempt attempt2 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-A", "PROD-B"),
            now.plusMinutes(3) // 3분 후
        );

        detector.isDuplicate(attempt1);
        boolean isDuplicate = detector.isDuplicate(attempt2);

        assertThat(isDuplicate).isTrue();
    }

    @Test
    @DisplayName("5분 경과 후에는 허용")
    void testAllowedAfter5Minutes() {
        LocalDateTime now = LocalDateTime.now();

        DuplicatePaymentDetector.PaymentAttempt attempt1 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-A", "PROD-B"),
            now
        );

        DuplicatePaymentDetector.PaymentAttempt attempt2 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-A", "PROD-B"),
            now.plusMinutes(6) // 6분 후
        );

        detector.isDuplicate(attempt1);
        boolean isDuplicate = detector.isDuplicate(attempt2);

        assertThat(isDuplicate).isFalse();
    }

    @Test
    @DisplayName("다른 사용자는 같은 상품/금액이어도 허용")
    void testDifferentUserAllowed() {
        LocalDateTime now = LocalDateTime.now();

        DuplicatePaymentDetector.PaymentAttempt attempt1 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-A", "PROD-B"),
            now
        );

        DuplicatePaymentDetector.PaymentAttempt attempt2 = new DuplicatePaymentDetector.PaymentAttempt(
            "user456", // 다른 사용자
            10000,
            Arrays.asList("PROD-A", "PROD-B"),
            now.plusSeconds(10)
        );

        detector.isDuplicate(attempt1);
        boolean isDuplicate = detector.isDuplicate(attempt2);

        assertThat(isDuplicate).isFalse();
    }

    @Test
    @DisplayName("다른 금액이면 허용")
    void testDifferentAmountAllowed() {
        LocalDateTime now = LocalDateTime.now();

        DuplicatePaymentDetector.PaymentAttempt attempt1 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-A", "PROD-B"),
            now
        );

        DuplicatePaymentDetector.PaymentAttempt attempt2 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            20000, // 다른 금액
            Arrays.asList("PROD-A", "PROD-B"),
            now.plusSeconds(10)
        );

        detector.isDuplicate(attempt1);
        boolean isDuplicate = detector.isDuplicate(attempt2);

        assertThat(isDuplicate).isFalse();
    }

    @Test
    @DisplayName("다른 상품이면 허용")
    void testDifferentProductsAllowed() {
        LocalDateTime now = LocalDateTime.now();

        DuplicatePaymentDetector.PaymentAttempt attempt1 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-A", "PROD-B"),
            now
        );

        DuplicatePaymentDetector.PaymentAttempt attempt2 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-C", "PROD-D"), // 다른 상품
            now.plusSeconds(10)
        );

        detector.isDuplicate(attempt1);
        boolean isDuplicate = detector.isDuplicate(attempt2);

        assertThat(isDuplicate).isFalse();
    }

    @Test
    @DisplayName("상품 순서가 달라도 같은 것으로 인식")
    void testProductOrderDoesNotMatter() {
        LocalDateTime now = LocalDateTime.now();

        DuplicatePaymentDetector.PaymentAttempt attempt1 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-A", "PROD-B", "PROD-C"),
            now
        );

        DuplicatePaymentDetector.PaymentAttempt attempt2 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-C", "PROD-A", "PROD-B"), // 순서만 다름
            now.plusMinutes(1)
        );

        detector.isDuplicate(attempt1);
        boolean isDuplicate = detector.isDuplicate(attempt2);

        assertThat(isDuplicate).isTrue();
    }

    @Test
    @DisplayName("오래된 레코드 정리 테스트")
    void testCleanupOldRecords() {
        LocalDateTime baseTime = LocalDateTime.of(2024, 1, 1, 10, 0);

        // 3개의 결제 시도 추가
        detector.isDuplicate(new DuplicatePaymentDetector.PaymentAttempt(
            "user1", 10000, List.of("A"), baseTime
        ));
        detector.isDuplicate(new DuplicatePaymentDetector.PaymentAttempt(
            "user2", 20000, List.of("B"), baseTime.plusMinutes(2)
        ));
        detector.isDuplicate(new DuplicatePaymentDetector.PaymentAttempt(
            "user3", 30000, List.of("C"), baseTime.plusMinutes(11) // 가장 최근 (4분 전)
        ));

        assertThat(detector.getRecordCount()).isEqualTo(3);

        // 15분 후에 정리 실행
        detector.cleanupOldRecords(baseTime.plusMinutes(15));

        // 5분 이상 지난 레코드들은 삭제되고, user3만 남음 (4분 전이라 유지)
        assertThat(detector.getRecordCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("경계값 테스트: 정확히 5분 후")
    void testExactly5MinutesLater() {
        LocalDateTime now = LocalDateTime.now();

        DuplicatePaymentDetector.PaymentAttempt attempt1 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-A"),
            now
        );

        DuplicatePaymentDetector.PaymentAttempt attempt2 = new DuplicatePaymentDetector.PaymentAttempt(
            "user123",
            10000,
            Arrays.asList("PROD-A"),
            now.plusMinutes(5) // 정확히 5분
        );

        detector.isDuplicate(attempt1);
        boolean isDuplicate = detector.isDuplicate(attempt2);

        assertThat(isDuplicate).isFalse(); // 5분 이상이므로 허용
    }

    @Test
    @DisplayName("동시 다발적 결제 시도 시뮬레이션")
    void testMultipleAttempts() {
        LocalDateTime now = LocalDateTime.now();

        // 같은 사용자, 다른 상품들
        detector.isDuplicate(new DuplicatePaymentDetector.PaymentAttempt(
            "user123", 10000, List.of("A", "B"), now
        ));
        detector.isDuplicate(new DuplicatePaymentDetector.PaymentAttempt(
            "user123", 20000, List.of("C", "D"), now.plusSeconds(30)
        ));
        detector.isDuplicate(new DuplicatePaymentDetector.PaymentAttempt(
            "user123", 30000, List.of("E", "F"), now.plusMinutes(1)
        ));

        // 첫 번째 결제와 같은 시도 (중복!)
        boolean isDuplicate = detector.isDuplicate(new DuplicatePaymentDetector.PaymentAttempt(
            "user123", 10000, List.of("A", "B"), now.plusMinutes(2)
        ));

        assertThat(isDuplicate).isTrue();
        assertThat(detector.getRecordCount()).isEqualTo(3); // 중복은 업데이트됨
    }

    @Test
    @DisplayName("학생 구현 테스트 (구현 후 주석 해제)")
    void testStudentImplementation() {
        // TODO: 구현 후 아래 주석을 해제하고 테스트하세요
         LocalDateTime now = LocalDateTime.now();
         DuplicatePaymentDetector.PaymentAttempt attempt1 = new DuplicatePaymentDetector.PaymentAttempt(
             "user123", 10000, Arrays.asList("PROD-A"), now
         );
         DuplicatePaymentDetector.PaymentAttempt attempt2 = new DuplicatePaymentDetector.PaymentAttempt(
             "user123", 10000, Arrays.asList("PROD-A"), now.plusMinutes(3)
         );
         detector.isDuplicate(attempt1);
         boolean isDuplicate = detector.isDuplicate(attempt2);
         assertThat(isDuplicate).isTrue();
    }
}
