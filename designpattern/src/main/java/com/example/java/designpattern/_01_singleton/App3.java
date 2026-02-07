package com.example.java.designpattern._01_singleton;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author : lhd
 * @packageName : com.example.java.designpattern.singleton
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-12         lhd
 */
public class App3 {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Data3 data3 = Data3.INSTANCE;

        Data3 data3_single = null;

        Constructor<?>[] declaredConstructor = Data3.class.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructor) {
            constructor.setAccessible(true);
            data3_single = (Data3) constructor.newInstance("INSTANCE");
        }

        // enum을 사용하면 객체 생성이 딱한번만 되기 때문에 singleton을 유지할 수 있음.
        // 단점은 class를 롣이하는 순간에 이미 객체가 만들어져있음.
        System.out.println(data3 == data3_single);
    }
}
