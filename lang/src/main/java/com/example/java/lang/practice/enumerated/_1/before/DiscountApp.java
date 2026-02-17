package com.example.java.lang.practice.enumerated._1.before;

public class DiscountApp {

    public static void main(String[] args) {

        DiscountPolicy policy = new DiscountPolicy();

        // 정상적으로 값을 넣었을때
        int vip = policy.discount("VIP", 10000);
        int black = policy.discount("BLACK", 10000);
        int white = policy.discount("WHITE", 10000);

        System.out.println("Vip: " + vip);
        System.out.println("Black: " + black);
        System.out.println("White: " + white);


        // 정상적으로 값을 넣지 못했을때 타입에 대한 안정성이 떨어진다.
        int vvip = policy.discount("vvip", vip);
        System.out.println("vvip: " + vvip);
    }
}
