package com.example.java.lang.intermediate.exception.basic.checked;

public class CheckedCatchMain {
    public static void main(String[] args) throws MyCheckedException {
        Service service = new Service();

        // 예외 처리
        service.callCatch();
        System.out.println("프로그램 종료");

        service.callThrows();
    }
}
