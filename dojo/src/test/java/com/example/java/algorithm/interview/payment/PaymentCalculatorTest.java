package com.example.java.algorithm.interview.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentCalculatorTest {

    private final PaymentCalculator calculator = new PaymentCalculator();

    @Test
    @DisplayName("기본 시나리오: 정률 쿠폰 + 포인트 사용 + 무료 배송")
    void testBasicScenario() {
        // 상품 금액: 50,000원, 10% 쿠폰, 5,000원 포인트
        PaymentCalculator.PaymentRequest request = new PaymentCalculator.PaymentRequest(
            new BigDecimal("50000"),
            new PaymentCalculator.Coupon(
                PaymentCalculator.CouponType.PERCENTAGE,
                new BigDecimal("10")
            ),
            5000
        );

        PaymentCalculator.PaymentResult result = calculator.calculateSolution(request);

        assertThat(result.getOriginalAmount()).isEqualByComparingTo("50000");
        assertThat(result.getCouponDiscount()).isEqualByComparingTo("5000"); // 10% of 50,000
        assertThat(result.getPointsUsed()).isEqualByComparingTo("5000");
        assertThat(result.getShippingFee()).isEqualByComparingTo("0"); // 무료 배송
        assertThat(result.getFinalAmount()).isEqualByComparingTo("40000"); // 50,000 - 5,000 - 5,000
    }

    @Test
    @DisplayName("정액 쿠폰 + 유료 배송")
    void testFixedCouponWithShipping() {
        // 상품 금액: 25,000원, 5,000원 쿠폰, 포인트 미사용
        PaymentCalculator.PaymentRequest request = new PaymentCalculator.PaymentRequest(
            new BigDecimal("25000"),
            new PaymentCalculator.Coupon(
                PaymentCalculator.CouponType.FIXED_AMOUNT,
                new BigDecimal("5000")
            ),
            0
        );

        PaymentCalculator.PaymentResult result = calculator.calculateSolution(request);

        assertThat(result.getCouponDiscount()).isEqualByComparingTo("5000");
        assertThat(result.getPointsUsed()).isEqualByComparingTo("0");
        assertThat(result.getShippingFee()).isEqualByComparingTo("3000"); // 3만원 미만이라 유료
        assertThat(result.getFinalAmount()).isEqualByComparingTo("23000"); // 25,000 - 5,000 + 3,000
    }

    @Test
    @DisplayName("포인트 최대 사용 제한 (50%)")
    void testMaxPointUsageLimit() {
        // 상품 금액: 10,000원, 10,000원 포인트 사용 시도 -> 최대 5,000원만 사용 가능
        PaymentCalculator.PaymentRequest request = new PaymentCalculator.PaymentRequest(
            new BigDecimal("10000"),
            null,
            10000 // 50% 초과 시도
        );

        PaymentCalculator.PaymentResult result = calculator.calculateSolution(request);

        assertThat(result.getPointsUsed()).isEqualByComparingTo("5000"); // 최대 50%만 사용
        assertThat(result.getShippingFee()).isEqualByComparingTo("3000");
        assertThat(result.getFinalAmount()).isEqualByComparingTo("8000"); // 10,000 - 5,000 + 3,000
    }

    @Test
    @DisplayName("포인트 100원 단위 검증 실패")
    void testPointUnitValidation() {
        PaymentCalculator.PaymentRequest request = new PaymentCalculator.PaymentRequest(
            new BigDecimal("50000"),
            null,
            5050 // 100원 단위 아님
        );

        assertThatThrownBy(() -> calculator.calculateSolution(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("100원 단위");
    }

    @Test
    @DisplayName("쿠폰 할인이 상품 금액보다 큰 경우")
    void testCouponExceedsAmount() {
        // 상품 금액보다 큰 쿠폰
        PaymentCalculator.PaymentRequest request = new PaymentCalculator.PaymentRequest(
            new BigDecimal("5000"),
            new PaymentCalculator.Coupon(
                PaymentCalculator.CouponType.FIXED_AMOUNT,
                new BigDecimal("10000")
            ),
            0
        );

        PaymentCalculator.PaymentResult result = calculator.calculateSolution(request);

        assertThat(result.getCouponDiscount()).isEqualByComparingTo("5000"); // 최대 상품 금액까지만
        assertThat(result.getFinalAmount()).isEqualByComparingTo("3000"); // 0 + 배송비
    }

    @Test
    @DisplayName("쿠폰 없이 포인트만 사용")
    void testPointsOnlyWithoutCoupon() {
        PaymentCalculator.PaymentRequest request = new PaymentCalculator.PaymentRequest(
            new BigDecimal("30000"),
            null,
            5000
        );

        PaymentCalculator.PaymentResult result = calculator.calculateSolution(request);

        assertThat(result.getCouponDiscount()).isEqualByComparingTo("0");
        assertThat(result.getPointsUsed()).isEqualByComparingTo("5000");
        assertThat(result.getShippingFee()).isEqualByComparingTo("0"); // 무료 배송
        assertThat(result.getFinalAmount()).isEqualByComparingTo("25000");
    }

    @Test
    @DisplayName("정률 쿠폰 소수점 버림 테스트")
    void testPercentageCouponRounding() {
        // 상품 금액: 12,345원, 15% 쿠폰
        PaymentCalculator.PaymentRequest request = new PaymentCalculator.PaymentRequest(
            new BigDecimal("12345"),
            new PaymentCalculator.Coupon(
                PaymentCalculator.CouponType.PERCENTAGE,
                new BigDecimal("15")
            ),
            0
        );

        PaymentCalculator.PaymentResult result = calculator.calculateSolution(request);

        // 12,345 * 0.15 = 1,851.75 -> 1,851 (소수점 버림)
        assertThat(result.getCouponDiscount()).isEqualByComparingTo("1851");
    }

    @Test
    @DisplayName("배송비 경계값 테스트: 정확히 30,000원")
    void testShippingFeeBoundary() {
        PaymentCalculator.PaymentRequest request = new PaymentCalculator.PaymentRequest(
            new BigDecimal("30000"),
            null,
            0
        );

        PaymentCalculator.PaymentResult result = calculator.calculateSolution(request);

        assertThat(result.getShippingFee()).isEqualByComparingTo("0"); // 30,000원 이상 무료
    }

    @Test
    @DisplayName("배송비 경계값 테스트: 29,999원")
    void testShippingFeeJustBelow() {
        PaymentCalculator.PaymentRequest request = new PaymentCalculator.PaymentRequest(
            new BigDecimal("29999"),
            null,
            0
        );

        PaymentCalculator.PaymentResult result = calculator.calculateSolution(request);

        assertThat(result.getShippingFee()).isEqualByComparingTo("3000"); // 유료
    }

    @Test
    @DisplayName("학생 구현 테스트 (구현 후 주석 해제)")
    void testStudentImplementation() {
        // TODO: 구현 후 아래 주석을 해제하고 테스트하세요
        // PaymentCalculator.PaymentRequest request = new PaymentCalculator.PaymentRequest(
        //     new BigDecimal("50000"),
        //     new PaymentCalculator.Coupon(PaymentCalculator.CouponType.PERCENTAGE, new BigDecimal("10")),
        //     5000
        // );
        // PaymentCalculator.PaymentResult result = calculator.calculate(request);
        // assertThat(result.getFinalAmount()).isEqualByComparingTo("40000");
    }
}
