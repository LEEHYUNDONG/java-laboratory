package com.example.java.lang.basic.polymorphism.basic.ex1;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.polymorphism.ex1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-12         lhd
 */
public class Dog extends Animal{
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
