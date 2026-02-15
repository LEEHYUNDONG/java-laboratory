package com.easttwave.pr.architecture.hexagonal.ads.serving.adapter.in.api;

import com.easttwave.pr.architecture.hexagonal.ads.serving.adapter.in.dto.ServableAdsRequest;
import com.easttwave.pr.architecture.hexagonal.ads.serving.application.port.in.ServableAdUsecase;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.ServableAd;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ads")
public class ServableAdController {

    private final ServableAdUsecase servableAdUsecase;

    public ServableAdController(ServableAdUsecase servableAdUsecase) {
        this.servableAdUsecase = servableAdUsecase;
    }

    @GetMapping("/serving")
    public ResponseEntity<ServableAd> getServableAds(@RequestBody ServableAdsRequest request) {
        return ResponseEntity.noContent().build();
    }

}
