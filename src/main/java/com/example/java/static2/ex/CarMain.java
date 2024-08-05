package com.example.java.static2.ex;

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
public class CarMain {

    public static void main(String[] args) {

        Car car1 = new Car("K3");
        Car car2 = new Car("G80");
        Car car3 = new Car("Model Y");

        Car.showTotalCars();
    }
}
