package com.example.java.practice.enumerated._1.after;

public class DiscountPolicy {


    public int discount(Grade grade, int amount) {
        int discountRate = 0;

        if(grade == Grade.VIP) {
            discountRate = Grade.VIP.getRate();
        } else if(grade == Grade.BLACK) {
            discountRate = Grade.BLACK.getRate();
        } else if(grade == Grade.WHITE) {
            discountRate = Grade.WHITE.getRate();
        } else {
            System.out.println("grade: " +grade + " 할인률: " + discountRate);
            discountRate = 0;
        }
        return discountRate * amount / 100;
    }
}
