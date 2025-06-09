package com.example.java.lang.intermediate.generic.ex3;

import com.example.java.lang.intermediate.generic.animal.Animal;

public class AnimalHospitalV3 <T extends Animal>{
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public T get() {
        return animal;
    }

    public void checkup() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
    }

    public T getBigger(T target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
