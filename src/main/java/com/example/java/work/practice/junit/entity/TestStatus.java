package com.example.java.work.practice.junit.entity;

public enum TestStatus {
    SUCCESS(1), FAILURE(0);

    private final int code;

    TestStatus(int code) {
        this.code = code;
    }
}
