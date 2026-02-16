package com.easttwave.pr.architecture.hexagonal.ads.tracking.application.service;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.AdId;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.DeviceInfo;
import com.easttwave.pr.architecture.hexagonal.ads.tracking.application.port.in.AdTrackingEventUsecase;
import com.easttwave.pr.architecture.hexagonal.ads.tracking.application.port.out.AdTrackingEventPublishPort;
import com.easttwave.pr.architecture.hexagonal.ads.tracking.domain.AdTrackingEvent;
import com.easttwave.pr.architecture.hexagonal.ads.tracking.domain.SlotId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdTrackingEventService implements AdTrackingEventUsecase {

    private final AdTrackingEventPublishPort adTrackingEventPublishPort;

    @Override
    public void createAdTrackingEvent(String eventType, AdId adId, SlotId slotId, DeviceInfo deviceInfo) {
        var trackingEvent = AdTrackingEvent.createTrackingEvent(eventType, adId, slotId, deviceInfo);

        adTrackingEventPublishPort.sendMessage(trackingEvent);
    }
}
