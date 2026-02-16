package com.easttwave.pr.architecture.hexagonal.ads.tracking.domain;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.AdId;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.DeviceInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@ToString(exclude = {"deviceInfo", "slotId"})
public class AdTrackingEvent {

    // 멱등성을 보장하기 위함
    private UUID eventId;

    private SlotId slotId;

    private AdId adId;

    private String eventType;

    private DeviceInfo deviceInfo;


    public static AdTrackingEvent createTrackingEvent(String eventType, AdId adId, SlotId slotId, DeviceInfo deviceInfo) {
        var adTrackingEvent = new AdTrackingEvent();
        adTrackingEvent.setEventId(UUID.randomUUID());
        adTrackingEvent.setSlotId(slotId);
        adTrackingEvent.setEventType(eventType);
        adTrackingEvent.setAdId(adId);
        adTrackingEvent.setDeviceInfo(deviceInfo);
        return adTrackingEvent;
    }

}
