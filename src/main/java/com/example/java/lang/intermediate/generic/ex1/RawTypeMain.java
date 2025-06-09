package com.example.java.lang.intermediate.generic.ex1;

public class RawTypeMain {
    public static void main(String[] args) {
        GenericBox integerBox = new GenericBox();
        integerBox.setValue(100);
        Integer result = (Integer) integerBox.getValue();
        System.out.println("result = " + result);
    }
}
