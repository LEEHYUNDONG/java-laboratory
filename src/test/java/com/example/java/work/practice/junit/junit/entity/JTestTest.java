package com.example.java.work.practice.junit.junit.entity;

import com.example.java.work.practice.junit.calculator.entity.CalculatorTest;
import org.junit.jupiter.api.Test;


class JTestTest {

    @Test
    void runTest() {
        //given
        JTest jTest = new JTest();
        //when
        jTest.run(CalculatorTest.class);

        //then


    }
}