package com.example.java.algorithm.interview.payment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 문제: 결제 상태 머신 (State Machine)
 *
 * 실무 시나리오:
 * 결제 시스템의 상태 전이를 관리하는 State Machine을 구현하세요.
 *
 * 상태 전이 규칙:
 * PENDING -> APPROVED -> COMPLETED (정상 흐름)
 * PENDING -> FAILED (결제 실패)
 * APPROVED -> FAILED (승인 후 처리 실패)
 * COMPLETED -> REFUND_REQUESTED -> REFUNDED (환불)
 * COMPLETED -> PARTIAL_REFUNDED (부분 환불)
 *
 * 제약사항:
 * - 잘못된 상태 전이는 예외를 발생시켜야 함
 * - 모든 상태 전이는 이력으로 기록되어야 함
 * - COMPLETED 상태 이후에는 PENDING이나 APPROVED로 돌아갈 수 없음
 *
 * 예시:
 * payment.transitionTo(APPROVED) -> 성공 (PENDING -> APPROVED)
 * payment.transitionTo(COMPLETED) -> 성공 (APPROVED -> COMPLETED)
 * payment.transitionTo(PENDING) -> 실패 (COMPLETED -> PENDING 불가)
 */
public class PaymentStateMachine {

    public enum PaymentStatus {
        PENDING,              // 결제 대기
        APPROVED,             // 승인됨
        COMPLETED,            // 완료됨
        FAILED,               // 실패
        REFUND_REQUESTED,     // 환불 요청됨
        PARTIAL_REFUNDED,     // 부분 환불됨
        REFUNDED              // 환불 완료됨
    }

    public static class Payment {
        private final String paymentId;
        private PaymentStatus currentStatus;
        private final List<StatusTransition> transitionHistory;

        public Payment(String paymentId) {
            this.paymentId = paymentId;
            this.currentStatus = PaymentStatus.PENDING;
            this.transitionHistory = new ArrayList<>();
            this.transitionHistory.add(new StatusTransition(
                null,
                PaymentStatus.PENDING,
                LocalDateTime.now(),
                "Payment created"
            ));
        }

        public String getPaymentId() {
            return paymentId;
        }

        public PaymentStatus getCurrentStatus() {
            return currentStatus;
        }

        public List<StatusTransition> getTransitionHistory() {
            return new ArrayList<>(transitionHistory);
        }

        public void transitionTo(PaymentStatus newStatus, String reason) {
            if (!isValidTransition(currentStatus, newStatus)) {
                throw new IllegalStateException(
                        String.format("Invalid transition: %s -> %s", currentStatus, newStatus)
                );
            }

            PaymentStatus oldStatus = currentStatus;
            currentStatus = newStatus;
            transitionHistory.add(new StatusTransition(
                    oldStatus,
                    newStatus,
                    LocalDateTime.now(),
                    reason
            ));
        }


        private boolean isValidTransition(PaymentStatus from, PaymentStatus to) {
            // 같은 상태로는 전이 불가
            if (from == to) {
                return false;
            }

            switch (from) {
                case PENDING:
                    return to == PaymentStatus.APPROVED || to == PaymentStatus.FAILED;

                case APPROVED:
                    return to == PaymentStatus.COMPLETED || to == PaymentStatus.FAILED;

                case COMPLETED:
                    return to == PaymentStatus.REFUND_REQUESTED ||
                           to == PaymentStatus.PARTIAL_REFUNDED;

                case FAILED:
                    return false; // 실패 상태에서는 다른 상태로 전이 불가

                case REFUND_REQUESTED:
                    return to == PaymentStatus.REFUNDED || to == PaymentStatus.PARTIAL_REFUNDED;

                case PARTIAL_REFUNDED:
                    return to == PaymentStatus.REFUND_REQUESTED; // 추가 환불 요청 가능

                case REFUNDED:
                    return false; // 환불 완료 후에는 상태 전이 불가

                default:
                    return false;
            }
        }
    }

    public static class StatusTransition {
        private final PaymentStatus fromStatus;
        private final PaymentStatus toStatus;
        private final LocalDateTime transitionTime;
        private final String reason;

        public StatusTransition(PaymentStatus fromStatus, PaymentStatus toStatus,
                              LocalDateTime transitionTime, String reason) {
            this.fromStatus = fromStatus;
            this.toStatus = toStatus;
            this.transitionTime = transitionTime;
            this.reason = reason;
        }

        public PaymentStatus getFromStatus() {
            return fromStatus;
        }

        public PaymentStatus getToStatus() {
            return toStatus;
        }

        public LocalDateTime getTransitionTime() {
            return transitionTime;
        }

        public String getReason() {
            return reason;
        }

        @Override
        public String toString() {
            return String.format("%s -> %s at %s: %s",
                fromStatus, toStatus, transitionTime, reason);
        }
    }
}
