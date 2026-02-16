package com.easttwave.pr.architecture.hexagonal.ads.shared.infrastructure.messaging;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeSqsClient {

    private List<FakeMessage> fakeQueue = new ArrayList<FakeMessage>();

    public <T> void sendMessage(String queueName, T message) {
        System.out.println("send message to: " + queueName);
        System.out.println("message: " + message.toString());

        fakeQueue.add(new FakeMessage(queueName, message));
    }

    public List<FakeMessage> getFakeQueue(){
        return fakeQueue;
    }
}
