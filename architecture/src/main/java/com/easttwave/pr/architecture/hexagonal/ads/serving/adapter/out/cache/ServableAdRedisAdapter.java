package com.easttwave.pr.architecture.hexagonal.ads.serving.adapter.out.cache;

import com.easttwave.pr.architecture.hexagonal.ads.serving.application.port.out.ServableAdRedisPort;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.ServableAd;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServableAdRedisAdapter implements ServableAdRedisPort {

    @Override
    public void saveServableAd(ServableAd servableAd) {
    }

    @Override
    public void removeServableAd(ServableAd servableAd) {

    }

    @Override
    public List<ServableAd> getServableAd() {
        return List.of();
    }

    @Override
    public ServableAd getServableAd(Long id) {
        return null;
    }
}
