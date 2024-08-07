package com.example.java.designpattern.singleton;

/**
 * @author : lhd
 * @packageName : com.example.java.designpattern.singleton
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-06         lhd
 */
public class App {
    public static void main(String[] args) {
        Data data1 = Data.getInstance();
        Data data2 = Data.getInstance();
        System.out.println(data1 == Data.getInstance());

    }
}
