package com.example.java.java1.basic.polymorphism.basic;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.polymorphism.basic
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-12         lhd
 */
public class PolyMain {
    public static void main(String[] args) {
        // 부모 변수가 부모 인스턴스 참조
        System.out.println(" Parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();
        System.out.println(" Child -> Child");
        Child child = new Child();
        child.childMethod();
        child.parentMethod();

    }
}
