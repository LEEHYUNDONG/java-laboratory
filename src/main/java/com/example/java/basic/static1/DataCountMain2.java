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
public class DataCountMain2 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Data2 data1 = new Data2("data1", counter);
        System.out.println("data1.count = " + counter.count);

        Data2 data2 = new Data2("data2", counter);
        System.out.println("data2.count = " + counter.count);

        Data2 data3 = new Data2("data3", counter);
        System.out.println("data3.count = " + counter.count);
    }
}
