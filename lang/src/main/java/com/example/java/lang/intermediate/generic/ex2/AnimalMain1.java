package com.example.java.lang.intermediate.generic.ex2;

import com.example.java.lang.intermediate.generic.animal.Animal;
import com.example.java.lang.intermediate.generic.animal.Cat;
import com.example.java.lang.intermediate.generic.animal.Dog;

public class AnimalMain1 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물", 3);
        Dog dog = new Dog("강아지", 10);
        Cat cat = new Cat("고양이", 5);

        Box<Dog> dogBox = new Box<>();
        dogBox.set(dog);
        Dog dogFromBox = dogBox.get();
        dogFromBox.sound(); // 멍멍
        System.out.println("findDog = " + dogFromBox); // findDog = Dog{name='강아지', size=10}

        Box<Cat> catBox = new Box<>();
        catBox.set(cat);
        Cat catFromBox = catBox.get();
        catFromBox.sound(); // 야옹
        System.out.println("findCat = " + catFromBox); // findCat = Cat{name='고양이', size=5}

        Box<Animal> animalBox = new Box<>();
        animalBox.set(animal);
        Animal findAnimal = animalBox.get();
        findAnimal.sound(); // 동물 울음 소리
        System.out.println("findAnimal = " + findAnimal); // findAnimal = Animal{name='동물', size=0}
    }
}
