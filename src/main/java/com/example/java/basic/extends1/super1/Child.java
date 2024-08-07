package com.example.java.basic.extends1.super1;

/**
 * @author : lhd
 * @packageName : com.example.java.extends1.super1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-06         lhd
 */
public class Child extends Parent{

    public String value = "child";

    public void hello() {
        System.out.println("Child.hello");

    }

    public void call() {
        System.out.println("this value = " + this.value);
        System.out.println("super value = " + super.value);

        this.hello();
        super.hello();
    }
}
