package com.example.java.lang.intermediate.exception.basic.unchecked;

public class UncheckedCatchMain {
    public static void main(String[] args) {
        Service service = new Service();
        service.callThrow();
        System.out.println("프로그램 종료");
    }
}
