package com.example.java.memory;

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
public class JavaMemoryMain2 {
    public static void main(String[] args) {
        System.out.println("main 메서드 시작");
        method1(12);
        System.out.println("main 메서드 종료");
    }

    private static void method1(int i) {
        System.out.println("method1 메서드 시작");
        Data data1 = new Data(i);
        method2(data1);
        System.out.println("method1 메서드 종료");
    }

    private static void method2(Data data1) {
        System.out.println("method2 메서드 시작");
        System.out.println("data1.getData() = " + data1.getData());
        System.out.println("method2 메서드 종료");
    }
}
