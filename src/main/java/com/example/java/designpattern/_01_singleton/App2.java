package com.example.java.designpattern._01_singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author : lhd
 * @packageName : com.example.java.designpattern.singleton
 * @fileName : java
 * @description : reflection을 이용하여 singleton 깨기
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-08         lhd
 */
public class App2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Data2 data = Data2.getInstance();

        // reflection
        Constructor<Data2> constructor = Data2.class.getDeclaredConstructor();
        Data2 data2 = constructor.newInstance();

        // 다른 인스턴스가 된다. 1
        System.out.println(data == data2);

    }
}
