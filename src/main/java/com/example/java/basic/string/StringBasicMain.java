package com.example.java.basic.string;

/**
 * @author : lhd
 * @packageName : com.example.java.string
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-05-31         lhd
 */
public class StringBasicMain {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        String str3 = new String("gello");
        String str4 = str3.concat(" java");

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("str3 = " + str3);
        System.out.println("str4 = " + str4);
    }
}
