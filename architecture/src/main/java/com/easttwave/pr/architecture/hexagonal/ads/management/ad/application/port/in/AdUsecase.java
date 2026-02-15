package com.easttwave.pr.architecture.hexagonal.ads.management.ad.application.port.in;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.in.dto.CreateAdRequest;
import com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.in.dto.UpdateAdRequest;
import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.Ad;

import java.util.List;

public interface AdUsecase {

    void registerAd(CreateAdRequest command);

    void deleteAd(String adId);

    void updateAd(UpdateAdRequest command);

    List<Ad> getAllAds();
}
