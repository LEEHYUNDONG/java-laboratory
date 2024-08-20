package com.example.java.lang.basic.polymorphism.interface1;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.polymorphism.interface1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-16         lhd
 */
public class ControllerMain {
    public static void main(String[] args) {
        ControllerInterface[] interfaces = {new CarController(), new RemoteController()};

        for (ControllerInterface anInterface : interfaces) {
            control(anInterface);
        }
    }

    private static void control(ControllerInterface anInterface) {
        anInterface.turnOn();
        anInterface.doSomething();
        anInterface.turnOff();
    }
}
