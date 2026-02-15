package com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.in.dto;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.ImageUri;
import com.easttwave.pr.architecture.hexagonal.ads.management.shared.domain.DateRange;

public record UpdateAdRequest(
        String adId,
        String title,
        String description,
        ImageUri imageUri,
        DateRange dateRange
) {

}
