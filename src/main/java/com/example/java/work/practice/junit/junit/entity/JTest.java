package com.example.java.work.practice.junit.junit.entity;

import java.lang.reflect.Method;

public class JTest {



    public void run(Class<?> testClass) {
        //제네릭을 사용해서 해당 클래스의 메소드를 불러온다.
        Method[] methods = testClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            
        }
    }

}

