package com.example.java.static2;

/**
 * @author : lhd
 * @packageName : com.example.java.static2
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-02         lhd
 */
public class DecoData {
    private int instaceValue;
    public static int staticValue;

    public static void staticCall() {

        // instaceValue++; // Error: Non-static field 'instaceValue' cannot be referenced from a static context
        // instaceValue++;

        // instaceMethod(); // Error: Non-static method 'instaceMethod()' cannot be referenced from a static context
        staticValue++;
        staticMethod();
    }

    public void instanceCall() {
        instaceValue++; // OK
        instaceMethod(); // OK

        staticValue++; // OK
        staticMethod(); // OK
    }

    private void instaceMethod() {
        System.out.println("instaceValue = " + instaceValue);
    }

    private static void staticMethod() {
        System.out.println("staticValue = " + staticValue);
    }
}
