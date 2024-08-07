package com.example.java.basic.static2.ex;

/**
 * @author : lhd
 * @packageName : com.example.java.static2.ex
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-05         lhd
 */
public class Car {
    private String name;
    private static int carCount;

    public Car(String name) {
        this.name = name;
        System.out.println("차량 구입, 이름: " + name);
        carCount++;
    }

    public static void showTotalCars() {
        System.out.println("구매한 차량 수: " + carCount);
    }
}
