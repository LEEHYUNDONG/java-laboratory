package com.example.java.advanced.generic;


public class ClassName<E> {
    private E element;

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    static <E> E method1(E o) {
        return o;
    }

    static <T> T method2(T o) {
        return o;
    }
}
