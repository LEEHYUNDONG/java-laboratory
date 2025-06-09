package com.example.java.lang.intermediate.generic.ex3;

import com.example.java.lang.intermediate.generic.animal.Cat;
import com.example.java.lang.intermediate.generic.animal.Dog;

public class AnimalHospitalMainV3 {
    public static void main(String[] args) {
        AnimalHospitalV3<Dog> dogHospital = new AnimalHospitalV3<>();
        AnimalHospitalV3<Cat> catHospital = new AnimalHospitalV3<>();
        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 300);

        dogHospital.set(dog);
        dogHospital.checkup(); // 동물 이름: 멍멍이1, 동물 크기: 100

        catHospital.set(cat);
        catHospital.checkup(); // 동물 이름: 냐옹이1, 동물 크기: 300

        Dog biggerDog = dogHospital.getBigger(new Dog("멍멍이2", 200));
        System.out.println("더 큰 개의 이름: " + biggerDog); // 더 큰 개의 이름: 멍멍이2
    }
}
