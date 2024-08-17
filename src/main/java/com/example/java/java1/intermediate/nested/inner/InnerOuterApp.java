package com.example.java.java1.intermediate.nested.inner;

public class InnerOuterApp {
    public static void main(String[] args) {
        InnerOuter outer = new InnerOuter();

        InnerOuter.Inner inner = outer.new Inner();
        inner.print();
    }
}
