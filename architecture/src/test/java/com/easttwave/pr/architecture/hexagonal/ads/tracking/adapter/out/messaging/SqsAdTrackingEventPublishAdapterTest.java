package com.easttwave.pr.architecture.hexagonal.ads.tracking.adapter.out.messaging;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.domain.AdId;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.DeviceInfo;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.ScreenSize;
import com.easttwave.pr.architecture.hexagonal.ads.shared.infrastructure.messaging.FakeMessage;
import com.easttwave.pr.architecture.hexagonal.ads.shared.infrastructure.messaging.FakeSqsClient;
import com.easttwave.pr.architecture.hexagonal.ads.tracking.domain.AdTrackingEvent;
import com.easttwave.pr.architecture.hexagonal.ads.tracking.domain.SlotId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
class SqsAdTrackingEventPublishAdapterTest {

    @Autowired
    private FakeSqsClient fakeSqsClient;

    private SqsAdAdTrackingEventPublishAdapter sqsAdAdTrackingEventPublishAdapter;

    @BeforeEach
    void setUp() {
        this.sqsAdAdTrackingEventPublishAdapter = new SqsAdAdTrackingEventPublishAdapter(fakeSqsClient);
    }

    @Test
    void sendMessage() {
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

        sqsAdAdTrackingEventPublishAdapter.sendMessage(trackingEvent);
        FakeMessage fakeMessage = fakeSqsClient.getFakeQueue().get(0);
        var expected = fakeMessage.toAdTrackingEvent();

        assertThat(trackingEvent.getEventId()).isEqualTo(expected.getEventId());
        assertThat(trackingEvent.getAdId()).isEqualTo(expected.getAdId());


    }
}