package com.easttwave.pr.architecture.hexagonal.ads.serving.application.port.out;

import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.ServableAd;

import java.util.List;

public interface ServableAdPersistencePort {

    List<ServableAd> getServableAd();

    ServableAd getServableAd(Long id);
}
