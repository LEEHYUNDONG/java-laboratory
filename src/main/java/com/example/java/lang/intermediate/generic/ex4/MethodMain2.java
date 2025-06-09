package com.example.java.lang.intermediate.generic.ex4;

import com.example.java.lang.intermediate.generic.animal.Cat;
import com.example.java.lang.intermediate.generic.animal.Dog;

public class MethodMain2 {
    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("야옹이", 100);

        AnimalMethod.checkup(dog); // 동물 이름: 멍멍이, 동물 크기: 100
        AnimalMethod.checkup(cat); // 동물 이름: 야옹이, 동물 크기: 100

        Dog targetDog = new Dog("멍멍이2", 200);
        System.out.println("bigger = " + AnimalMethod.getBigger(dog, targetDog)); // bigger = 멍멍이2
    }
}
