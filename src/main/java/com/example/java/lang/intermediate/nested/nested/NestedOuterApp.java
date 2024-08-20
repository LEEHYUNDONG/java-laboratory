package com.example.java.lang.intermediate.nested.nested;

/**
 * @author : lhd
 * @packageName : com.example.java.java1.intermediate.nested.nested
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-19         lhd
 */
public class NestedOuterApp {
    public static void main(String[] args) {
        // NestedOuter nestedOuter = new NestedOuter();
        NestedOuter.Nested nested = new NestedOuter.Nested();
        nested.print();

        System.out.println("nestedClass = " + nested.getClass());
    }
}
