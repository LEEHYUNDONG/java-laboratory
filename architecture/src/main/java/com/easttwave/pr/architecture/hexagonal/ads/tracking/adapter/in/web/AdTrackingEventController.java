package com.easttwave.pr.architecture.hexagonal.ads.tracking.adapter.in.web;


import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.AdId;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.DeviceInfo;
import com.easttwave.pr.architecture.hexagonal.ads.tracking.domain.SlotId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdTrackingEventController {


    @GetMapping("/api/v1/ad/{eventType}")
    public ResponseEntity<?> createAdTrackingEvent(
            @PathVariable String eventType,
            @RequestParam AdId adId,
            @RequestParam SlotId slotId,
            @RequestHeader DeviceInfo deviceInfo
    ) {

        return ResponseEntity.ok().build();
    }
}
