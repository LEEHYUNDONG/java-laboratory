package com.easttwave.pr.architecture.hexagonal.ads.tracking.domain;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.AdId;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.DeviceInfo;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.ScreenSize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdTrackingEventTest {

    @Test
    void createAdTrackingEventTest(){
        var adId = new AdId("kakao-ad-1");
        var slotId = new SlotId("main-header-1");
        var deviceInfo = new DeviceInfo("1",
                "ios",
                "11.2.0",
                new ScreenSize(100, 200));

        var trackingEvent = AdTrackingEvent.createTrackingEvent(
                "impression",
                adId,
                slotId,
                deviceInfo
        );

        assertNotNull(trackingEvent);
        assertEquals(adId, trackingEvent.getAdId());
        assertEquals(slotId, trackingEvent.getSlotId());
        assertEquals(deviceInfo, trackingEvent.getDeviceInfo());
    }

}