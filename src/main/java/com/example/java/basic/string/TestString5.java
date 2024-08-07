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
public class TestString5 {
    public static void main(String[] args) {
        String str = "hello.txt";
        String ext = ".txt";

        System.out.println("fileName = " + str.substring(0, str.indexOf(ext)));
        System.out.println("extName = " + str.substring(str.indexOf(ext)));

    }
}
