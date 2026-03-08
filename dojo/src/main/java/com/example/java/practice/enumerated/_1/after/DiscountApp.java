package com.example.java.practice.enumerated._1.after;

public class DiscountApp {

    public static void main(String[] args) {

        DiscountPolicy policy = new DiscountPolicy();

        // 정상적으로 값을 넣었을때
        int vip = policy.discount(Grade.VIP, 10000);
        int black = policy.discount(Grade.BLACK, 10000);
        int white = policy.discount(Grade.WHITE, 10000);

        System.out.println("Vip: " + vip);
        System.out.println("Black: " + black);
        System.out.println("White: " + white);


        // 열거형을 사용할 경우 type checking에서 오류가 발생하여 정상적으로 값을 뽑을수 없다.
//        int vvip = policy.discount("vvip", vip);
//        System.out.println("vvip: " + vvip);
    }
}
