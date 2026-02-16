package com.easttwave.pr.architecture.hexagonal.ads.tracking.adapter.in.dto;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.AdId;

public record AdTrackingEventRequest(
        AdId adId
) {
}
