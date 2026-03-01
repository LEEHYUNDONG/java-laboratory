package com.example.java.lang.advanced._1.thread.bounded;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class ConsumerTask implements Runnable {
    private BoundedQueue queue;

    ConsumerTask(BoundedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log("[소비 시도]  ? <- " + queue);
        String data = queue.take();
        log("[소비 완료] " + data + " -> " + queue);
    }
}
