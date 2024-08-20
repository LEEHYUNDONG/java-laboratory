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
public class RemoteController implements ControllerInterface{
    @Override
    public void turnOn() {
        System.out.println("tv 전원을 켠다.");
    }

    @Override
    public void turnOff() {
        System.out.println("tv 전원을 끈다.");

    }

    @Override
    public void doSomething() {
        System.out.println("채널을 돌린다.");
    }

    @Override
    public void doSome() {
        ControllerInterface.super.doSome();
    }
}
