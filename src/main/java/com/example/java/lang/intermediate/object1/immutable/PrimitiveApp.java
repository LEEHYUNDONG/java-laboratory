package com.example.java.lang.intermediate.object1.immutable;

/**
 * @author : lhd
 * @packageName : com.example.java.java1.intermediate.object1.immutable
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-20         lhd
 */
public class PrimitiveApp {
    public static void main(String[] args) {
        // 기본형 같은 값 공유 x
        int a = 10;
        int b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        b = 20;
        b = a;

        System.out.println("b = " + b);

    }
}
