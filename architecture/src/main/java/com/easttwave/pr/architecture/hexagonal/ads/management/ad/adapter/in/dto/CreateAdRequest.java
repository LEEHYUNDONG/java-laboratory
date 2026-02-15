package com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.in.dto;

import java.time.LocalDate;

public record CreateAdRequest(
        String adId,
        String title,
        String description,
        String imageUri,
        LocalDate startDate,
        LocalDate endDate
) {
}
