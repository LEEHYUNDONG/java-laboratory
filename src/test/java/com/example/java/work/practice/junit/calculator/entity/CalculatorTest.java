package com.example.java.work.practice.junit.calculator.entity;

import com.example.java.work.practice.junit.junit.annotation.AfterEachJ;
import com.example.java.work.practice.junit.junit.annotation.BeforeEachJ;
import com.example.java.work.practice.junit.junit.annotation.TestJ;

public class CalculatorTest {

    public static int runSetupOrNot = 0;

    @BeforeEachJ
    void setUp() {
        System.out.println("before each");
        runSetupOrNot++;
    }

    @AfterEachJ
    void tearDown() {
        System.out.println("after each");
    }

    @TestJ
    void add() {
        //when
        System.out.println("add 테스트");
    }

    @TestJ
    void subtract() throws Exception {
        System.out.println("substract 테스트");
        throw new Exception("error");
    }

    @TestJ
    void multiply() {
        System.out.println("multiply 테스트");
    }

    @TestJ
    void divide() {
        System.out.println("divide 테스트");
    }

}
