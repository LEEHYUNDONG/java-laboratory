package com.example.java.basic.polymorphism.basic.ex1;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.polymorphism.ex1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-12         lhd
 */
public class AnimalMain2 {
    public static void main(String[] args) {
        Animal[] animals = {new Cat(), new Dog(), new Cow()};

        for (Animal animal : animals) {
            System.out.println("동물 울음 소리 시작");
            animal.sound();
            System.out.println("동물 울음 소리 종료");
        }
    }
}
