package com.example.java.basic.memory;

/**
 * @author : lhd
 * @packageName : com.example.java.memory
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-02         lhd
 */
public class JavaMemoryMain1 {
    public static void main(String[] args) {
        System.out.println("main 메서드 시작");
        method1(10);
        System.out.println("main 메서드 종료");

    }

    static void method1(int m1) {
        System.out.println("method1 메서드 시작");
        int cal = m1 * 2;
        method2(cal);
        System.out.println("method1 메서드 종료");
    }

    private static void method2(int m2) {
        System.out.println("method2 메서드 시작");

        System.out.println("method2 메서드 종료");
    }
}
