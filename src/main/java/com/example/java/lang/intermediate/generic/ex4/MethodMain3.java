package com.example.java.lang.intermediate.generic.ex4;

import com.example.java.lang.intermediate.generic.animal.Cat;
import com.example.java.lang.intermediate.generic.animal.Dog;

public class MethodMain3 {
    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("야옹이", 100);


        ComplexBox<Dog> hospital = new ComplexBox<>();
        hospital.set(dog);

        Cat returnCat = hospital.printAndReturn(cat);
        System.out.println("returnCat = " + returnCat); // returnCat = 야옹이
    }
}
