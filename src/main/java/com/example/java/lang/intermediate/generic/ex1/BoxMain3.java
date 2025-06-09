package com.example.java.lang.intermediate.generic.ex1;

public class BoxMain3 {
    public static void main(String[] args) {
        // Using GenericBox with Integer
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.setValue(123);
        Integer intValue = integerBox.getValue();
        System.out.println("Integer value: " + intValue);

        // Using GenericBox with String
        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.setValue("Hello, Generics!");
        String strValue = stringBox.getValue();
        System.out.println("String value: " + strValue);

        // Using GenericBox with Double
        GenericBox<Double> doubleBox = new GenericBox<>();
        doubleBox.setValue(45.67);
        Double doubleValue = doubleBox.getValue();
        System.out.println("Double value: " + doubleValue);

    }
}
