package com.example.java.practice.junit.assertJ.entity;

public class ObjAssert<T> {

    public static <T> ObjAssert<T> assertThat(T actual){
        return new ObjAssert<>();
    }
}
