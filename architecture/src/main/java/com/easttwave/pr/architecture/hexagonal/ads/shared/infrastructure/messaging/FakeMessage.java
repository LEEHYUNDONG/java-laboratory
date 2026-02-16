package com.easttwave.pr.architecture.hexagonal.ads.shared.infrastructure.messaging;

import com.easttwave.pr.architecture.hexagonal.ads.tracking.domain.AdTrackingEvent;

public class FakeMessage {

    private final String queueName;
    private final Object message;

    public FakeMessage(String queueName, Object message) {
        this.queueName = queueName;
        this.message = message;
    }

    public String getQueueName() {
        return queueName;
    }

    public Object getMessage() {
        return message;
    }

    public AdTrackingEvent toAdTrackingEvent() {
        if (message instanceof AdTrackingEvent) {
            return (AdTrackingEvent) message;
        }
        throw new IllegalStateException("Message is not an AdTrackingEvent: " + message.getClass());
    }
}
