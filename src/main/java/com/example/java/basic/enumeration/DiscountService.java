package com.example.java.basic.enumeration;

/**
 * @author : lhd
 * @packageName : com.example.java.enumeration
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-06-03         lhd
 */
public class DiscountService {


    public int discount(String grade, int price) {
        int discountPercent = 0;

        if(grade.equals("BASIC")){
            discountPercent = 10;
        }else if(grade.equals("GOLD")) {
            discountPercent = 20;
        } else if(grade.equals("DIAMOND")) {
            discountPercent = 30;
        } else {
            System.out.println(grade + " : 할인X");
        }

        return price * discountPercent / 100;
    }
}
