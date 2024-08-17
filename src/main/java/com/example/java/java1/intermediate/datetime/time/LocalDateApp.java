package com.example.java.java1.intermediate.datetime.time;

import java.time.LocalDate;

public class LocalDateApp {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2013, 12, 30);
        System.out.println("오늘날짜 :" + now);
        System.out.println("ofDate = " + ofDate);

        // 계산 불변
        ofDate = ofDate.plusDays(1);
        System.out.println("ofDate + 1 = " + ofDate);

    }
}
