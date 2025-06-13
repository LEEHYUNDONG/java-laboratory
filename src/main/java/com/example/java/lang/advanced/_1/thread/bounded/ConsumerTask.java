package com.example.java.lang.advanced._1.thread.bounded;

public class ConsumerTask implements Runnable {
    private BoundedQueue queue;

    ConsumerTask(BoundedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("[소비 시도]  ? <- " + queue);
        String data = queue.take();
        System.out.println("[소비 완료] " + data + " -> " + queue);
    }
}
