package com.example.java.practice.enumerated._1.before;

public class DiscountPolicy {


    public int discount(String grade, int amount) {
        int discountRate = 0;

        if(grade == "VIP") {
            discountRate = 30;
        } else if(grade == "BLACK") {
            discountRate = 20;
        } else if(grade == "WHITE") {
            discountRate = 10;
        } else {
            System.out.println("grade: " +grade + " 할인률: " + discountRate);
            discountRate = 0;
        }
        return discountRate * amount / 100;
    }
}
