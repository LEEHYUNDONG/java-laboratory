package com.example.java.lang.intermediate.generic.ex3;

import com.example.java.lang.intermediate.generic.animal.Dog;

public class AnimalHostpitalMainV1 {
    public static void main(String[] args) {
        AnimalHospitalV1 dogHospital = new AnimalHospitalV1();
        AnimalHospitalV1 catHospital = new AnimalHospitalV1();
        Dog dog = new Dog("멍멍이1", 100);
        Dog cat = new Dog("냐옹이1", 300);
        dogHospital.set(dog);
        dogHospital.checkup(); // 동물 이름: 멍멍이1, 동물 크기: 100
        catHospital.set(cat);
        catHospital.checkup(); // 동물 이름: 냐옹이1, 동물 크기: 300
    }
}
