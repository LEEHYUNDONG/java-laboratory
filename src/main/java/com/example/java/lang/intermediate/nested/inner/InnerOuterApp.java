package com.example.java.lang.intermediate.nested.inner;

public class InnerOuterApp {
    public static void main(String[] args) {
        InnerOuter outer = new InnerOuter();

        InnerOuter.Inner inner = outer.new Inner();
        inner.print();
    }
}
