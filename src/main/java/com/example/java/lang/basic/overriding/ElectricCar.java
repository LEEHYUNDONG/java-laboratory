package com.example.java.lang.basic.overriding;

/**
 * @author : lhd
 * @packageName : com.example.java.extends1.ex2
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-06         lhd
 */
public class ElectricCar extends Car {

    @Override
    public void move() {
        System.out.println("전기차를 빠르게 이동합니다.");
    }
    public void charge() {
        System.out.println("차를 충전합니다.");
    }
}
