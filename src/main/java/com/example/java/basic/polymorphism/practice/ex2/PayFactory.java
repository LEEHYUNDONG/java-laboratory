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
public abstract class PayFactory {


    public static Pay findPay(String options) {
        if(options.equals("naver")) {
            return new NaverPay();
        } else if(options.equals("kakao")) {
            return new KakaoPay();
        } else if(options.equals("new")) {
            return new NewPay();
        } else {
            return new NoPay();
        }
    }
}
