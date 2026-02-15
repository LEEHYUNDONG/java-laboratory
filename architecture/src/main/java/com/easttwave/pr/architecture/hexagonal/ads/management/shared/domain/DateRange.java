package com.easttwave.pr.architecture.hexagonal.ads.management.shared.domain;

import lombok.Getter;

import java.time.LocalDate;


@Getter
public class DateRange {

    LocalDate startDate;

    LocalDate endDate;

    public DateRange(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static boolean isValidDate(LocalDate date) {
        return date.isAfter(LocalDate.now());
    }
}
