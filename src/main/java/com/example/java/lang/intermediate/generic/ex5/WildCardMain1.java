package com.example.java.lang.intermediate.generic.ex5;

import com.example.java.lang.intermediate.generic.animal.Animal;
import com.example.java.lang.intermediate.generic.animal.Cat;
import com.example.java.lang.intermediate.generic.animal.Dog;

public class WildCardMain1 {
    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();
        dogBox.set(new Dog("멍멍이", 100));

        WildCardEx.printGenericV1(dogBox); // T = null
        WildCardEx.printWildcardV1(dogBox); // T = null
        WildCardEx.printGenericV2(dogBox);
        WildCardEx.printWildcardV2(dogBox);

        Dog dog = WildCardEx.printAndReturnGeneric(dogBox);
        Animal animal = WildCardEx.printAndReturnWildcard(dogBox);
    }
}
