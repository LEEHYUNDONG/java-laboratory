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
public class CarController implements ControllerInterface{
    @Override
    public void turnOn() {
        System.out.println("시동을 건다.");
    }

    @Override
    public void turnOff() {
        System.out.println("시동을 끈다.");
    }

    @Override
    public void doSomething() {
        System.out.println("차가 주행한다.");
    }

    @Override
    public void doSome() {
        ControllerInterface.super.doSome();
    }
}
