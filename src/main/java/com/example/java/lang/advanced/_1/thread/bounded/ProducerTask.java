package com.example.java.lang.advanced._1.thread.bounded;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class ProducerTask implements Runnable{

    private BoundedQueue queue;
    private String request;

    ProducerTask(BoundedQueue queue, String request) {
        this.queue = queue;
        this.request = request;
    }


    @Override
    public void run() {
        log("[생산 시도] " + request + " -> " + queue);
        try {
            queue.put(request);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log("[생산 완료] " + request + " -> " + queue);
    }
}
