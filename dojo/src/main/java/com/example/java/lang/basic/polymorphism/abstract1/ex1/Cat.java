package com.example.java.lang.basic.polymorphism.abstract1.ex1;

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
public class Cat extends AbstractAnimal{
    @Override
    public void move() {
        System.out.println("Cat.move");
    }

    @Override
    public void sound() {
        System.out.println("Cat.sound");
    }
}
