package com.easttwave.pr.architecture.layered.controller;

import com.easttwave.pr.architecture.hexagonal.ads.serving.adapter.in.dto.ServableAdsRequest;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.ServableAd;
import com.easttwave.pr.architecture.layered.service.ServableAdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ServableAdController {

    private final ServableAdService servableAdService;

    @PostMapping("/api/v1/serve/ad")
    public ResponseEntity<List<ServableAd>> serveAd(@RequestBody ServableAdsRequest request) {
        return ResponseEntity.ok(servableAdService.getServableAds(request));

    }
}
