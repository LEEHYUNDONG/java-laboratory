package com.example.java.java1.intermediate.enumeration;

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
public class GradeEx0_1 {

    public static void main(String[] args) {
        int price = 100000;

        DiscountService discountService = new DiscountService();

        int basic = discountService.discount("BASIC", price);
        int gold = discountService.discount("GOLD", price);
        int dia = discountService.discount("DIAMOND", price);

        System.out.println("dia = " + dia);
        System.out.println("gold = " + gold);
        System.out.println("basic = " + basic);
    }
}
