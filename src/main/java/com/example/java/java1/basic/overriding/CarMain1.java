package com.example.java.java1.basic.overriding;

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
public class CarMain1 {
    /**
     * 부모는 자식의 존재에 대해ㅏ여 모르지만 자식은 부모의 기능을 물려받아 사용할 수 있다.
     * 반면에 부모는 자식 클래스에 접근할 수 없다.
     * @author easttwave
     * @date 2024-08-06
     * @param args
     */
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        // GasCar gasCar = new GasCar();
        // HydrogenCar hydrogenCar = new HydrogenCar();

        electricCar.openDoor(); 
        electricCar.move();
        electricCar.charge();

        // gasCar.openDoor();
        //gasCar.move();
        //gasCar.fillup();

        //hydrogenCar.openDoor();
        //hydrogenCar.move();
        //hydrogenCar.fillHydrogen();

    }
}
