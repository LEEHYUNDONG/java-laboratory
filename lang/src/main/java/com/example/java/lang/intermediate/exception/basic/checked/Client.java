package com.example.java.lang.intermediate.exception.basic.checked;

public class Client {
    public void call() throws MyCheckedException{
        throw new MyCheckedException("ex");
    }
}
