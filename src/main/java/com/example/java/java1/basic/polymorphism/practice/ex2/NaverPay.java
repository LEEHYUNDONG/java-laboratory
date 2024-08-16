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
public class NaverPay implements Pay{

    @Override
    public boolean pay(int amount) {
        System.out.println("네이버 시스템과 연결합니다.");
        System.out.println(amount + "원 결제를 시도합니다.");
        return true;
    }
}
