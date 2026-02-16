package com.easttwave.pr.architecture.hexagonal.ads.tracking.application.port.in;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.AdId;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.DeviceInfo;
import com.easttwave.pr.architecture.hexagonal.ads.tracking.domain.SlotId;

public interface AdTrackingEventUsecase {

    void createAdTrackingEvent(String eventType, AdId adId, SlotId slotId, DeviceInfo deviceInfo);
}
