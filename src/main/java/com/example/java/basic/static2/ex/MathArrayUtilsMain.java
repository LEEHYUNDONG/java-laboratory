package com.example.java.basic.static2.ex;

/**
 * @author : lhd
 * @packageName : com.example.java.static2.ex
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-05         lhd
 */
public class MathArrayUtilsMain {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6};

        System.out.println("sum=" + MathArrayUtils.sum(values));
        System.out.println("average=" + MathArrayUtils.average(values));
        System.out.println("min=" + MathArrayUtils.min(values));
        System.out.println("max=" + MathArrayUtils.max(values));

    }
}
