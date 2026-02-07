package com.example.java.lang.intermediate.object1.tostring;

/**
 * @author : lhd
 * @packageName : com.example.java.java1.intermediate.object1.tostring
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-20         lhd
 */
public class Car {
    private String carModel;

    public void go() {
        System.out.println("자동차가 갑니다.");
    }

    public Car(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                '}';
    }
}
