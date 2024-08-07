package com.example.java.basic.static1;

/**
 * @author : lhd
 * @packageName : com.example.java.static1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-02         lhd
 */
public class Data3 {
    public String name;
    public static int count;

    public Data3(String name) {
        this.name = name;
        count++;
    }
}
