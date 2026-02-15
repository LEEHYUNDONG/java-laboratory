package com.easttwave.pr.architecture.hexagonal.ads.serving.domain;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.Ad;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.PRIVATE)
@Getter
public class ServableAd {

    private String title;

    private String description;

    private String redirectUrl;

    private String impressionUrl;

    private DeviceInfo deviceInfo;

    public static ServableAd of(Ad ad) {
        ServableAd servableAd = new ServableAd();
        servableAd.setTitle(ad.getTitle());
        servableAd.setDescription(ad.getDescription());

        return servableAd;
    }
}
