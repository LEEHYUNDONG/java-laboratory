package com.example.java.lang.advanced._3.lambda;

public class AdderApp {

    public static void main(String[] args) {
        // 람다는 () -> {} 파라미터 리스트 -> 화살표 -> 바디로 구성된다.
        Adder adder = (int a, int b) -> a + b;
        System.out.println(adder.add(10, 20));
    }

}
