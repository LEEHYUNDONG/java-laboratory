package com.easttwave.pr.architecture.hexagonal.ads.serving.adapter.in.dto;

import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.DeviceInfo;

import java.util.List;

public record ServableAdsRequest(
        List<String> slotId,
        DeviceInfo deviceInfo
) {
}
