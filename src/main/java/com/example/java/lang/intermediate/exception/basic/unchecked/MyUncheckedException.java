package com.example.java.lang.intermediate.exception.basic.unchecked;

public class MyUncheckedException extends RuntimeException{
    public MyUncheckedException(String message) {
        super(message);
    }

    public MyUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyUncheckedException(Throwable cause) {
        super(cause);
    }
}
