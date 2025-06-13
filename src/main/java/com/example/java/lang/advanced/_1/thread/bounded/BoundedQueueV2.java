package com.example.java.lang.advanced._1.thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;
import static com.example.java.lang.advanced._1.thread.util.ThreadUtils.sleep;

public class BoundedQueueV2 implements BoundedQueue{
    private final Queue<String> queue = new ArrayDeque<>();

    private final int capacity;

    public BoundedQueueV2(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public synchronized void put(String data) {
        while(queue.size() == capacity) {
            log("[put] 큐가 가득참, 생산자 대기" + data);
            sleep(1000);
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        while(queue.isEmpty()) {
            log("[take] 큐가 비어있음, 소비자 대기");
            sleep(1000);
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
