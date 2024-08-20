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
public interface ControllerInterface {
    void turnOn();
    void turnOff();
    void doSomething();
    default void doSome() {
        System.out.println("ControllerInterface.doSome");
    }
}
