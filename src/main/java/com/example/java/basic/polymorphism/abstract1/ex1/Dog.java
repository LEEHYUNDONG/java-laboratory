package com.example.java.basic.polymorphism.abstract1.ex1;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.polymorphism.abstract1.ex1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-16         lhd
 */
public class Dog extends AbstractAnimal{
    @Override
    public void move() {
        System.out.println("Dog.move");
    }

    @Override
    public void sound() {
        System.out.println("Dog.sound");
    }
}
