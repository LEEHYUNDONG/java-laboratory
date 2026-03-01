package com.example.java.practice.junit.junit.entity;

import com.example.java.practice.junit.calculator.entity.CalculatorTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JTestTest {


    private static final int TEST_CNT = 4;

    @Test
    void runTest() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        //given
        int passed = 3;
        int failed = 1;
        JTest jTest = new JTest();
        String resultMessageExpected = "passed: " + passed + " failed: " + failed;

        //when
        JTestResult result = jTest.run(CalculatorTest.class);


        //then
        // 테스트 결과와 테스트가 성공을 출력하는지 확인
        assertThat(result.getTestStatus()).isEqualTo(TestStatus.FAILURE);
        Assertions.assertThat(result.printMessage()).isEqualTo(resultMessageExpected);
    }



    @Test
    void testBeforeEach() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        //given
        JTest jTest = new JTest();

        //when
        jTest.run(CalculatorTest.class);

        assertThat(CalculatorTest.runSetupOrNot).isEqualTo(TEST_CNT);
    }
}