package com.easttwave.pr.architecture.hexagonal.ads.serving.application.service;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.application.port.out.AdPersistencePort;
import com.easttwave.pr.architecture.hexagonal.ads.serving.adapter.in.dto.ServableAdsRequest;
import com.easttwave.pr.architecture.hexagonal.ads.serving.application.port.in.ServableAdUsecase;
import com.easttwave.pr.architecture.hexagonal.ads.serving.application.port.out.ServableAdRedisPort;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.ServableAd;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServableAdService implements ServableAdUsecase {

    private final ServableAdRedisPort servableAdRedisPort;

    private final AdPersistencePort adPersistencePort;

    public ServableAdService(ServableAdRedisPort servableAdRedisPort, AdPersistencePort adPersistencePort) {
        this.servableAdRedisPort = servableAdRedisPort;
        this.adPersistencePort = adPersistencePort;
    }

    @Override
    public List<ServableAd> serve(ServableAdsRequest request) {
        List<ServableAd> servableAd = servableAdRedisPort.getServableAd();
        if(servableAd != null) {
            return servableAd;
        }

        return adPersistencePort.findAllAds().stream()
                .map(ServableAd::of)
                .toList();
    }
}
