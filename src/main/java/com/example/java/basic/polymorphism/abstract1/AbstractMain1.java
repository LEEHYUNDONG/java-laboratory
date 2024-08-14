package com.example.java.basic.polymorphism.abstract1;

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
public class AbstractMain1 {
    public static void main(String[] args) {
        ElectronicDevice[] devices = {new Phone(), new Tv()};

        for (ElectronicDevice electronicDevice : devices) {
            electronicDevice.turnOn();
            electronicDevice.doSomething();
            electronicDevice.turnOff();
        }
        
    }
}
