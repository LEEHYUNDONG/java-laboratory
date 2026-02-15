package com.easttwave.pr.architecture.hexagonal.ads.management.ad.application.port.out;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.Ad;

import java.util.List;
import java.util.Optional;

public interface AdPersistencePort {

    void saveAd(Ad ad);

    void removeAd(String adId);

    List<Ad> findAllAds();

    void updateAd(String adId, Ad ad);

    Optional<Ad> findByAdId(String adId);
}
