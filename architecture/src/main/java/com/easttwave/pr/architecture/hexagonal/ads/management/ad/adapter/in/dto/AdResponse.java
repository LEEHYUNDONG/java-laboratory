package com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.in.dto;

import com.easttwave.pr.architecture.hexagonal.ads.management.shared.domain.DateRange;

public record AdResponse(
        String adId,
        String title,
        String description,
        String imageUri,
        DateRange dateRange
) {
    public static AdResponse of(com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.Ad ad) {
        return new AdResponse(
                ad.getAdId().value(),
                ad.getTitle(),
                ad.getDescription(),
                ad.getImageUri().toString(),
                ad.getDateRange()
        );
    }
}
