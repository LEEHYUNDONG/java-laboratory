package com.example.java.algorithm.interview.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.java.algorithm.interview.payment.PaymentStateMachine.PaymentStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentStateMachineTest {

    @Test
    @DisplayName("정상 결제 흐름: PENDING -> APPROVED -> COMPLETED")
    void testNormalFlow() {
        PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("PAY-001");

        assertThat(payment.getCurrentStatus()).isEqualTo(PENDING);

        payment.transitionTo(APPROVED, "Payment approved");
        assertThat(payment.getCurrentStatus()).isEqualTo(APPROVED);

        payment.transitionTo(COMPLETED, "Payment completed");
        assertThat(payment.getCurrentStatus()).isEqualTo(COMPLETED);

        assertThat(payment.getTransitionHistory()).hasSize(3);
    }

    @Test
    @DisplayName("결제 실패 시나리오: PENDING -> FAILED")
    void testPaymentFailure() {
        PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("PAY-002");

        payment.transitionTo(FAILED, "Insufficient balance");

        assertThat(payment.getCurrentStatus()).isEqualTo(FAILED);
        assertThat(payment.getTransitionHistory()).hasSize(2);
    }

    @Test
    @DisplayName("승인 후 실패: APPROVED -> FAILED")
    void testApprovedToFailed() {
        PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("PAY-003");

        payment.transitionTo(APPROVED, "Approved");
        payment.transitionTo(FAILED, "Processing error");

        assertThat(payment.getCurrentStatus()).isEqualTo(FAILED);
    }

    @Test
    @DisplayName("환불 흐름: COMPLETED -> REFUND_REQUESTED -> REFUNDED")
    void testRefundFlow() {
        PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("PAY-004");

        payment.transitionTo(APPROVED, "Approved");
        payment.transitionTo(COMPLETED, "Completed");
        payment.transitionTo(REFUND_REQUESTED, "Customer requested refund");
        payment.transitionTo(REFUNDED, "Refund processed");

        assertThat(payment.getCurrentStatus()).isEqualTo(REFUNDED);
        assertThat(payment.getTransitionHistory()).hasSize(5);
    }

    @Test
    @DisplayName("부분 환불: COMPLETED -> PARTIAL_REFUNDED")
    void testPartialRefund() {
        PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("PAY-005");

        payment.transitionTo(APPROVED, "Approved");
        payment.transitionTo(COMPLETED, "Completed");
        payment.transitionTo(PARTIAL_REFUNDED, "Partial refund");

        assertThat(payment.getCurrentStatus()).isEqualTo(PARTIAL_REFUNDED);
    }

    @Test
    @DisplayName("부분 환불 후 추가 환불 요청")
    void testPartialRefundThenMoreRefund() {
        PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("PAY-006");

        payment.transitionTo(APPROVED, "Approved");
        payment.transitionTo(COMPLETED, "Completed");
        payment.transitionTo(PARTIAL_REFUNDED, "Partial refund");
        payment.transitionTo(REFUND_REQUESTED, "More refund requested");

        assertThat(payment.getCurrentStatus()).isEqualTo(REFUND_REQUESTED);
    }

    @Test
    @DisplayName("잘못된 전이: PENDING -> COMPLETED (APPROVED 건너뜀)")
    void testInvalidTransitionSkipApproved() {
        PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("PAY-007");

        assertThatThrownBy(() -> payment.transitionTo(COMPLETED, "Invalid"))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("Invalid transition: PENDING -> COMPLETED");
    }

    @Test
    @DisplayName("잘못된 전이: COMPLETED -> PENDING (역방향)")
    void testInvalidTransitionBackward() {
        PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("PAY-008");

        payment.transitionTo(APPROVED, "Approved");
        payment.transitionTo(COMPLETED, "Completed");

        assertThatThrownBy(() -> payment.transitionTo(PENDING, "Invalid"))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("Invalid transition");
    }

    @Test
    @DisplayName("FAILED 상태에서는 다른 상태로 전이 불가")
    void testNoTransitionFromFailed() {
        PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("PAY-009");

        payment.transitionTo(FAILED, "Failed");

        assertThatThrownBy(() -> payment.transitionTo(PENDING, "Retry"))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("Invalid transition: FAILED");
    }

    @Test
    @DisplayName("REFUNDED 상태에서는 다른 상태로 전이 불가")
    void testNoTransitionFromRefunded() {
        PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("PAY-010");

        payment.transitionTo(APPROVED, "Approved");
        payment.transitionTo(COMPLETED, "Completed");
        payment.transitionTo(REFUND_REQUESTED, "Refund requested");
        payment.transitionTo(REFUNDED, "Refunded");

        assertThatThrownBy(() -> payment.transitionTo(COMPLETED, "Invalid"))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("Invalid transition: REFUNDED");
    }

    @Test
    @DisplayName("같은 상태로는 전이 불가")
    void testNoTransitionToSameState() {
        PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("PAY-011");

        assertThatThrownBy(() -> payment.transitionTo(PENDING, "Same state"))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("Invalid transition: PENDING -> PENDING");
    }

    @Test
    @DisplayName("전이 이력 확인")
    void testTransitionHistory() {
        PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("PAY-012");

        payment.transitionTo(APPROVED, "Approved by system");
        payment.transitionTo(COMPLETED, "Completed successfully");

        var history = payment.getTransitionHistory();

        assertThat(history).hasSize(3);
        assertThat(history.get(0).getFromStatus()).isNull();
        assertThat(history.get(0).getToStatus()).isEqualTo(PENDING);
        assertThat(history.get(1).getFromStatus()).isEqualTo(PENDING);
        assertThat(history.get(1).getToStatus()).isEqualTo(APPROVED);
        assertThat(history.get(2).getFromStatus()).isEqualTo(APPROVED);
        assertThat(history.get(2).getToStatus()).isEqualTo(COMPLETED);
    }

    @Test
    @DisplayName("학생 구현 테스트 (구현 후 주석 해제)")
    void testStudentImplementation() {
        // TODO: 구현 후 아래 주석을 해제하고 테스트하세요
        // PaymentStateMachine.Payment payment = new PaymentStateMachine.Payment("TEST");
        // payment.transitionTo(APPROVED, "Test");
        // assertThat(payment.getCurrentStatus()).isEqualTo(APPROVED);
    }
}
