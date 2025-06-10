package com.example.java.lang.intermediate.exception.ex4.exception;

public class NetworkClientExceptionV4 extends RuntimeException {
    private final String message;

    public NetworkClientExceptionV4(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
