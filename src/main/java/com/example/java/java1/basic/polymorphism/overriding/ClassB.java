package com.example.java.java1.basic.polymorphism.overriding;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.polymorphism.overriding
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-12         lhd
 */
public class ClassB extends ClassA{

    public String value = "child";

    @Override
    public void method() {
        System.out.println("ClassB.method");
    }
}
