package com.example.java.work.practice.junit.junit.entity;

import com.example.java.work.practice.junit.calculator.entity.CalculatorTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class JTestTest {

    @Test
    void runTest() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        //given
        int passed = 4;
        int failed = 0;
        JTest jTest = new JTest();
        String resultMessageExpected = "passed: " + passed + " failed: " + failed;

        //when
        JTestResult result = jTest.run(CalculatorTest.class);


        //then
        // 테스트 결과와 테스트가 성공을 출력하는지 확인
        assertThat(result.getTestStatus()).isEqualTo(TestStatus.SUCCESS);
        Assertions.assertThat(result.printMessage()).isEqualTo(resultMessageExpected);
    }
}