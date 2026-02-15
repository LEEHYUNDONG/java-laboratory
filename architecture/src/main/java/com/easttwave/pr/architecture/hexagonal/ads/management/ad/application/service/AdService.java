package com.easttwave.pr.architecture.hexagonal.ads.management.ad.application.service;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.in.dto.CreateAdRequest;
import com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.in.dto.UpdateAdRequest;
import com.easttwave.pr.architecture.hexagonal.ads.management.ad.application.port.in.AdUsecase;
import com.easttwave.pr.architecture.hexagonal.ads.management.ad.application.port.out.AdPersistencePort;
import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.Ad;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService implements AdUsecase {

    private final AdPersistencePort adPersistencePort;

    public AdService(AdPersistencePort adPersistencePort) {
        this.adPersistencePort = adPersistencePort;
    }

    @Override
    @Transactional
    public void registerAd(CreateAdRequest command) {
        Ad ad = Ad.createAds(command);

        adPersistencePort.saveAd(ad);
    }

    @Override
    public void deleteAd(String adId) {
        adPersistencePort.removeAd(adId);
    }

    @Override
    @Transactional
    public void updateAd(UpdateAdRequest command) {
        Ad ad = adPersistencePort.findByAdId(command.adId()).orElseThrow(() -> new IllegalArgumentException("Ad not found"));

        ad.updateDescription(command.description());

        adPersistencePort.updateAd(command.adId(), ad);
    }

    @Override
    public List<Ad> getAllAds() {
        return adPersistencePort.findAllAds();
    }
}
