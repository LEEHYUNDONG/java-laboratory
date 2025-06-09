package com.example.java.lang.intermediate.generic.ex1;

public class BoxMain1 {
    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox();
        integerBox.setValue(100);
        Integer integerValue = integerBox.getValue();
        System.out.println("IntegerBox value: " + integerValue);

        StringBox stringBox = new StringBox();
        stringBox.setValue("Hello, World!");
        String stringValue = stringBox.getValue();
        System.out.println("StringBox value: " + stringValue);
    }
}
