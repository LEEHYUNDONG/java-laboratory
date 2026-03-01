package com.example.java.lang.basic.polymorphism.basic.ex1;

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
public class AnimalMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow caw = new Cow();

        animalSound(dog);
        animalSound(cat);
        animalSound(caw);

    }
    public static void animalSound(Animal animal) {
        System.out.println("동물 울음 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 울음 소리 테스트 종료");
    }
}
