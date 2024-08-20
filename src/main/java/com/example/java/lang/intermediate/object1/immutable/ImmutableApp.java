package com.example.java.lang.intermediate.object1.immutable;

/**
 * @author : lhd
 * @packageName : com.example.java.java1.intermediate.object1.immutable
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-20         lhd
 */
public class ImmutableApp {

    public static void main(String[] args) {
        Item item1 = new Item("item1");
        Item item2;

        item2 = item1;
        System.out.println(item1 + " " + item2); // 참조형 같은 메모리 참조

    }
}
