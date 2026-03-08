package com.example.java.practice.nested;

public class OuterApp {

    public static void main(String[] args) {
        InnerOuter innerOuter = new InnerOuter();

        // 생성부터 안된다.
        InnerOuter.Inner inner = innerOuter.new Inner();
        inner.print();
    }
}
