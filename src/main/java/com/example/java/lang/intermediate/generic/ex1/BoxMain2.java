package com.example.java.lang.intermediate.generic.ex1;

public class BoxMain2 {
    public static void main(String[] args) {
        ObjectBox objectBox = new ObjectBox();
        objectBox.set(100);
        Integer integerValue = (Integer) objectBox.get();
        System.out.println("ObjectBox value: " + integerValue);

        objectBox.set("Hello, World!");
        String stringValue = (String) objectBox.get();
        System.out.println("ObjectBox value: " + stringValue);

//        ObjectBox integerBox = new ObjectBox();
//        integerBox.set("200");
//        Integer intValue = (Integer) integerBox.get();
//        System.out.println("ObjectBox value: " + intValue);

    }
}
