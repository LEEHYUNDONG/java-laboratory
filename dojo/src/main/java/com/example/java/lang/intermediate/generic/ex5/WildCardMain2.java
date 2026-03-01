package com.example.java.lang.intermediate.generic.ex5;

import com.example.java.lang.intermediate.generic.animal.Animal;
import com.example.java.lang.intermediate.generic.animal.Cat;
import com.example.java.lang.intermediate.generic.animal.Dog;

public class WildCardMain2 {
    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        writeBox(objBox);
        writeBox(animalBox);
        // 하위 타입 write 불가
//        writeBox(dogBox);
        Animal animal = animalBox.get();
        System.out.println("animal = " + animal); // animal = 멍멍이
    }

    private static void writeBox(Box<? super Animal> objBox) {
        objBox.set(new Dog("멍멍이", 100));
    }
}
