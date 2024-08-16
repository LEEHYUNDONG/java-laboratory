package com.example.java.java1.basic.polymorphism.abstract1.ex1;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.polymorphism.abstract1.ex1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-16         lhd
 */
public class App {
    public static void main(String[] args) {
        AbstractAnimal dog = new Dog();
        AbstractAnimal cat = new Cat();
        AbstractAnimal[] animals = {dog, cat};

        for (AbstractAnimal animal : animals) {
            print(animal);
        }
    }

    private static void print(AbstractAnimal animal) {
        animal.move();
        animal.sound();
    }
}
