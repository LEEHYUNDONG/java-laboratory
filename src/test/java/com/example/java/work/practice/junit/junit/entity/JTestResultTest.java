package com.example.java.work.practice.junit.junit.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JTestResultTest {
    @Test
    void getSuccessTestResult(){
        // given
        int passed = 1;
        int failed = 0;
        JTestResult testResult = new JTestResult(passed, failed);

        // when
        String message = testResult.printMessage();

        // then
        assertThat(message).isEqualTo("passed: " + passed +" failed: " + failed);
        Assertions.assertEquals(testResult.getStatus(), TestStatus.SUCCESS);
    }

    @Test
    void getFailureTestResult(){
        //given
        int passed = 1;
        int failed = 1;
        JTestResult testResult = new JTestResult(passed, failed);

        //when
        Assertions.assertAll(
                () -> assertThat(testResult.getStatus()).isEqualTo(TestStatus.FAILURE),
                () -> assertThat(testResult.printMessage()).isEqualTo("passed: " + passed +" failed: " + failed)
                );
    }
}