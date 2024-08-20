package com.example.java.lang.intermediate.object1.equals;

/**
 * @author : lhd
 * @packageName : com.example.java.java1.intermediate.object1.equals
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-20         lhd
 */
public class EqualsApp {
    public static void main(String[] args) {
        Item item1 = new Item("item1");
        Item item2 = new Item("item1");

        System.out.println(item1.equals(item2));
    }
}
