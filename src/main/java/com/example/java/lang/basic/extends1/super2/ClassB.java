package com.example.java.lang.basic.extends1.super2;

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
public class ClassB extends ClassA{

    public ClassB(int a) {
//        super();
        this(a, 0);
        System.out.println("Class B constructor a=" + a);
    }

    public ClassB(int a, int b) {
        super();
        System.out.println("Class B constructor a=" + a + ", b=" + b);
    }
}
