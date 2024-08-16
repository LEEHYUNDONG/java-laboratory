package com.example.java.java1.basic.static1;

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
public class Data2 {
    public String name;
    public static int count;

    public Data2(String name, Counter counter) {
        this.name = name;
        counter.count++;
    }
}
