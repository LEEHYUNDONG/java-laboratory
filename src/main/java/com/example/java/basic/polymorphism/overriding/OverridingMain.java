package com.example.java.basic.polymorphism.overriding;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.polymorphism.overriding
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-12         lhd
 */
public class OverridingMain {
    public static void main(String[] args) throws NoSuchMethodException {

        ClassA classA = new ClassA();
        classA.method();


        ClassB classB = new ClassB();
        // 본인 method 출력
        classB.method();
        ((ClassA) classB).method();

        // 부모 method 호출 (다형성)
        ClassA poly = new ClassB();
        System.out.println("ClassA -> ClassB");
        System.out.println(poly.value);
        poly.method();

        //instance of를 확인할 수 있음.

    }
}
