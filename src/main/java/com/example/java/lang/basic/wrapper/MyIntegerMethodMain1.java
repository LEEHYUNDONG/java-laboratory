package com.example.java.lang.basic.wrapper;

/**
 * @author : lhd
 * @packageName : com.example.java.wrapper
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-05-31         lhd
 */
public class MyIntegerMethodMain1 {

    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger(132000);

        int i1 = myInteger.compareTo(20);
        int i2 = myInteger.compareTo(12000320);
        int i3 = myInteger.compareTo(-2);

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
    }
}
