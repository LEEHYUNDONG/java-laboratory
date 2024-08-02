package com.example.java.wrapper;

import java.util.Objects;

/**
 * @author : lhd
 * @packageName : com.example.java.wrapper
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-05-31         lhd
 */
public class MyInteger {
    private final int value;


    public MyInteger(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyInteger myInteger = (MyInteger) o;
        return value == myInteger.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getValue() {
        return value;
    }

    public int compareTo(int target) {
        if (value < target) {
            return -1;
        } else if (value > target) {
            return 1;
        } else {
            return 0;
        }
    }


    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
