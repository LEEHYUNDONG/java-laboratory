package com.easttwave.pr.architecture.hexagonal.ads.serving.application.port.in;

import com.easttwave.pr.architecture.hexagonal.ads.serving.adapter.in.dto.ServableAdsRequest;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.ServableAd;

import java.util.List;

public interface ServableAdUsecase {

    List<ServableAd> serve(ServableAdsRequest request);


}
