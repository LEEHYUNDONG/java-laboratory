package com.example.java.lang.basic.static1;

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
public class DataCountMain1 {
    public static void main(String[] args) {
        Data1 data1 = new Data1("data1");
        System.out.println("data1.count = " + data1.count);

        Data1 data2 = new Data1("data2");
        System.out.println("data2.count = " + data2.count);

        Data1 data3 = new Data1("data3");
        System.out.println("data3.count = " + data3.count);
    }
}
