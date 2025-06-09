package com.example.java.lang.intermediate.generic.ex4;

import com.example.java.lang.intermediate.generic.animal.Animal;

public class ComplexBox<T extends Animal> {
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public T get() {
        return animal;
    }

    public <Z> Z printAndReturn(Z z) {
        System.out.println("animal.className: " +
                animal.getClass().getName());
        System.out.println("t.className: " + z.getClass().getName());
        // t.getName(); // 호출 불가 메서드는 <T> 타입이다. <T extends Animal> 타입이아니다.
        return z;
    }



}
