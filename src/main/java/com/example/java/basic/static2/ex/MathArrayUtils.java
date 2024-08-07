package com.example.java.basic.static2.ex;

import java.util.Arrays;

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
public class MathArrayUtils {

    private MathArrayUtils() {
    }

    public static int sum(int[] values) {
        return Arrays.stream(values).sum();
    }

    public static double average(int[] values) {
        return (double) sum(values) / values.length;
    }

    public static int min(int[] values) {
        return Arrays.stream(values).min().getAsInt();
    }

    public static int max(int[] values) {
        return Arrays.stream(values).max().getAsInt();
    }
}
