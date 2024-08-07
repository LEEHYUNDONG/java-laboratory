package com.example.java.basic.overriding;

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
public class Car {
    public void move() {
        System.out.println("차를 이동합니다.");
    }

    // 추가
    public void openDoor() {
        System.out.println("차의 문을 엽니다.");
    }
}
