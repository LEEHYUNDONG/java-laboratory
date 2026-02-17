package com.example.java.lang.practice.enumerated._1.after;

public enum Grade {
    VIP("VIP", 30),
    BLACK("BLACK", 20),
    WHITE("WHITE", 10);
    private final String value;
    private final int rate;

    Grade(String value, int rate) {
        this.value = value;
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
