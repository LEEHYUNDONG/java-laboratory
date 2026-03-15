package com.example.java.algorithm.interview.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 문제: 결제 금액 계산기
 *
 * 실무 시나리오:
 * 온라인 쇼핑몰에서 최종 결제 금액을 계산하는 시스템을 구현하세요.
 * 다음 순서대로 할인이 적용됩니다:
 * 1. 쿠폰 할인 (정액 또는 정률)
 * 2. 포인트 사용 (최대 상품 금액의 50%까지)
 * 3. 배송비 추가 (3만원 이상 무료, 미만시 3000원)
 *
 * 제약사항:
 * - 모든 금액은 원(KRW) 단위이며 소수점 이하는 버림
 * - 최종 결제 금액은 0원 미만이 될 수 없음
 * - 포인트는 100원 단위로만 사용 가능
 *
 * 예시:
 * 상품 금액: 50,000원
 * 쿠폰: 10% 할인
 * 포인트: 5,000원 사용
 * 배송비: 무료 (3만원 이상)
 * 최종 금액: 40,000원 (50,000 * 0.9 - 5,000 + 0)
 */
public class PaymentCalculator {

    public static class PaymentRequest {
        private final BigDecimal productAmount;
        private final Coupon coupon;
        private final int pointsToUse;

        public PaymentRequest(BigDecimal productAmount, Coupon coupon, int pointsToUse) {
            this.productAmount = productAmount;
            this.coupon = coupon;
            this.pointsToUse = pointsToUse;
        }

        public BigDecimal getProductAmount() {
            return productAmount;
        }

        public Coupon getCoupon() {
            return coupon;
        }

        public int getPointsToUse() {
            return pointsToUse;
        }
    }

    public static class Coupon {
        private final CouponType type;
        private final BigDecimal value;

        public Coupon(CouponType type, BigDecimal value) {
            this.type = type;
            this.value = value;
        }

        public CouponType getType() {
            return type;
        }

        public BigDecimal getValue() {
            return value;
        }
    }

    public enum CouponType {
        FIXED_AMOUNT,    // 정액 (예: 5,000원)
        PERCENTAGE       // 정률 (예: 10%)
    }

    public static class PaymentResult {
        private final BigDecimal originalAmount;
        private final BigDecimal couponDiscount;
        private final BigDecimal pointsUsed;
        private final BigDecimal shippingFee;
        private final BigDecimal finalAmount;

        public PaymentResult(BigDecimal originalAmount, BigDecimal couponDiscount,
                           BigDecimal pointsUsed, BigDecimal shippingFee, BigDecimal finalAmount) {
            this.originalAmount = originalAmount;
            this.couponDiscount = couponDiscount;
            this.pointsUsed = pointsUsed;
            this.shippingFee = shippingFee;
            this.finalAmount = finalAmount;
        }

        public BigDecimal getOriginalAmount() {
            return originalAmount;
        }

        public BigDecimal getCouponDiscount() {
            return couponDiscount;
        }

        public BigDecimal getPointsUsed() {
            return pointsUsed;
        }

        public BigDecimal getShippingFee() {
            return shippingFee;
        }

        public BigDecimal getFinalAmount() {
            return finalAmount;
        }
    }

    private static final BigDecimal FREE_SHIPPING_THRESHOLD = new BigDecimal("30000");
    private static final BigDecimal SHIPPING_FEE = new BigDecimal("3000");
    private static final BigDecimal MAX_POINT_USAGE_RATE = new BigDecimal("0.5");
    private static final int POINT_UNIT = 100;

    /**
     * 최종 결제 금액을 계산합니다.
     */
    public PaymentResult calculate(PaymentRequest request) {
        BigDecimal originalAmount = request.getProductAmount();

        // 1. 쿠폰 적용가 계산
        BigDecimal couponAmount;
        Coupon coupon = request.getCoupon();

        if (coupon == null) {
            couponAmount = BigDecimal.ZERO;
        } else {
            if (coupon.getType() == CouponType.FIXED_AMOUNT) {
                couponAmount = coupon.getValue();
            } else {
                couponAmount = originalAmount.multiply(coupon.getValue()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
            }
        }
        couponAmount = couponAmount.min(originalAmount);



        // 2. 포인트 사용 가능 체크
        // 100원 단위
        int pointsToUseRequest = request.getPointsToUse();
        BigDecimal pointsToUse;
        BigDecimal maxPointUsage = originalAmount.multiply(MAX_POINT_USAGE_RATE)
                .setScale(0, RoundingMode.DOWN);

        if (pointsToUseRequest == 0) {
            pointsToUse = BigDecimal.ZERO;
        } else {
             pointsToUse = BigDecimal.valueOf(pointsToUseRequest);
            if (pointsToUse.intValueExact() % POINT_UNIT != 0) {
                throw new IllegalArgumentException("100원 단위로 포인트 사용이 가능합니다.");
            }

            pointsToUse = new BigDecimal(Math.min(
                    pointsToUseRequest,
                    maxPointUsage.intValue()
            ));
        }

        // 배송비 계산
        BigDecimal shippingFee;
        if (originalAmount.compareTo(FREE_SHIPPING_THRESHOLD) >= 0) {
            shippingFee = BigDecimal.ZERO;
        } else {
            shippingFee = SHIPPING_FEE;
        }

        return new PaymentResult(originalAmount, couponAmount, pointsToUse, shippingFee, originalAmount.subtract(couponAmount).subtract(pointsToUse).add(shippingFee));
    }

    // 정답 (참고용)
    public PaymentResult calculateSolution(PaymentRequest request) {
        BigDecimal productAmount = request.getProductAmount();

        // 1. 쿠폰 할인 계산
        BigDecimal couponDiscount = calculateCouponDiscount(productAmount, request.getCoupon());
        BigDecimal amountAfterCoupon = productAmount.subtract(couponDiscount);

        // 2. 포인트 사용 금액 검증 및 적용
        BigDecimal maxPointUsage = productAmount.multiply(MAX_POINT_USAGE_RATE)
            .setScale(0, RoundingMode.DOWN);
        int requestedPoints = request.getPointsToUse();

        // 포인트 100원 단위 검증
        if (requestedPoints % POINT_UNIT != 0) {
            throw new IllegalArgumentException("포인트는 100원 단위로만 사용 가능합니다");
        }

        BigDecimal pointsToUse = new BigDecimal(Math.min(
            requestedPoints,
            maxPointUsage.intValue()
        ));

        BigDecimal amountAfterPoints = amountAfterCoupon.subtract(pointsToUse);

        // 3. 배송비 계산 (원래 상품 금액 기준)
        BigDecimal shippingFee = productAmount.compareTo(FREE_SHIPPING_THRESHOLD) >= 0
            ? BigDecimal.ZERO
            : SHIPPING_FEE;

        // 4. 최종 금액 계산
        BigDecimal finalAmount = amountAfterPoints.add(shippingFee);

        // 0원 미만 체크
        if (finalAmount.compareTo(BigDecimal.ZERO) < 0) {
            finalAmount = BigDecimal.ZERO;
        }

        return new PaymentResult(
            productAmount,
            couponDiscount,
            pointsToUse,
            shippingFee,
            finalAmount.setScale(0, RoundingMode.DOWN)
        );
    }

    private BigDecimal calculateCouponDiscount(BigDecimal amount, Coupon coupon) {
        if (coupon == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal discount;
        if (coupon.getType() == CouponType.FIXED_AMOUNT) {
            discount = coupon.getValue();
        } else {
            // 정률 할인 (소수점 이하 버림)
            discount = amount.multiply(coupon.getValue().divide(new BigDecimal("100")))
                .setScale(0, RoundingMode.DOWN);
        }

        // 할인 금액이 상품 금액보다 클 수 없음
        return discount.min(amount);
    }
}
