package com.easttwave.pr.architecture.hexagonal.ads.serving.adapter.in.dto;

import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.DeviceInfo;

public record DeviceHeader(
        String deviceId,
        String os,
        String appVersion,
        DeviceInfo deviceInfo

) {
}
