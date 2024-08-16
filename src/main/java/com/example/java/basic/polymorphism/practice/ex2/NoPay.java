package com.example.java.basic.polymorphism.practice.ex2;

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
public class NoPay implements Pay{
    @Override
    public boolean pay(int amount) {
        System.out.println("결제 수단이 없습니다.");
        return false;
    }
}
