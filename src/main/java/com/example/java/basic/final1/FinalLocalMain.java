package com.example.java.basic.final1;

/**
 * @author : lhd
 * @packageName : com.example.java.final1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-05         lhd
 */
public class FinalLocalMain {
    public static void main(String[] args) {

        // final 지역 변수1
        final int data1;
        data1 = 10; // 최초 한번만 할당 가능
//        data1 = 20; // 컴파일 오류


        // final 지역 변수2
        final int data2 = 10;
        //data2 = 20;


    }

    static void method(final int parameter) {

        //parameter = 20; // 컴파일 오류
    }
}
