package com.example.java.java1.basic.polymorphism.practice.ex2;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.polymorphism.practice.ex2
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-16         lhd
 */
public class PayApp {
    public static void main(String[] args) {
        PayService payService = new PayService();

        String payOption1 = "kakao";
        int amount1 = 5000;
        payService.processPay(payOption1, amount1);

        String payOption2 = "naver";
        int amount2 = 10000;
        payService.processPay(payOption2, amount2);

        String payOption3 = "bad";
        int amount3 = 20000;
        payService.processPay(payOption3, amount3);

        String payOption4 = "new";
        int amount4 = 10000;
        payService.processPay(payOption4, amount4);

    }
}
