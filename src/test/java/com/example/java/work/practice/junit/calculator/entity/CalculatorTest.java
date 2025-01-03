package com.example.java.work.practice.junit.calculator.entity;

import com.example.java.work.practice.junit.junit.entity.JTest;

public class CalculatorTest {

    private Calculator calculator;


    void add() {
        //given
        Calculator calculator = new Calculator();
        JTest jTest = new JTest();

        //when
        int result = calculator.add(1, 2);

        //then
        ObjAssert.assertThat(result).isEqualTo(calculator(1, 2));

    }

}
