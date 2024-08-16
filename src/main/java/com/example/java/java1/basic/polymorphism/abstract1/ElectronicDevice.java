package com.example.java.java1.basic.polymorphism.abstract1;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.polymorphism.abstract1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-14         lhd
 */
public abstract class ElectronicDevice {
    abstract void doSomething();

    public void turnOn() {
        System.out.println("전원 켬");
    }
    
    public void turnOff() {
        System.out.println("전원 끔");
    }
    
}
