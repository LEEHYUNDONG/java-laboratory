package com.easttwave.pr.architecture.hexagonal.ads.tracking.application.port.out;

import com.easttwave.pr.architecture.hexagonal.ads.tracking.domain.AdTrackingEvent;

public interface AdTrackingEventPublishPort {
    void sendMessage(AdTrackingEvent trackingEvent);
}
