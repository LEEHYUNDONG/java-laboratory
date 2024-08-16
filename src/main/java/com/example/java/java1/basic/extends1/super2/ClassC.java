package com.example.java.java1.basic.extends1.super2;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.extends1.super2
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-08         lhd
 */
public class ClassC extends ClassB{

    public ClassC() {
//        super(10);
        super(10, 20);
        System.out.println("Class C Constructor");
    }
}
