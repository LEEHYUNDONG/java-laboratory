package com.easttwave.pr.architecture.hexagonal.ads.tracking.adapter.out.messaging;

import com.easttwave.pr.architecture.hexagonal.ads.shared.infrastructure.messaging.FakeSqsClient;
import com.easttwave.pr.architecture.hexagonal.ads.tracking.application.port.out.AdTrackingEventPublishPort;
import com.easttwave.pr.architecture.hexagonal.ads.tracking.domain.AdTrackingEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SqsAdAdTrackingEventPublishAdapter implements AdTrackingEventPublishPort {

    private static final String queueName = "ad-tracking-event-queue.fifo";

    // 추상화해서 실제 운영과 local, test를 갈아 낄수 있도록 구성해야함
    private final FakeSqsClient fakeSqsClient;

    @Override
    public void sendMessage(AdTrackingEvent trackingEvent) {
        fakeSqsClient.sendMessage(queueName, trackingEvent);
    }
}
