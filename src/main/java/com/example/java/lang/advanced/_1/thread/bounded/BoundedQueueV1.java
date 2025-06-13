package com.example.java.lang.advanced._1.thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class BoundedQueueV1 implements BoundedQueue{
    private final Queue<String> queue = new ArrayDeque<>();

    private final int capacity;

    public BoundedQueueV1(int capacity) {
        this.capacity = capacity;
    }
    @Override
    public synchronized void put(String data) {
        if(queue.size() == capacity) {
            log("[put] 큐가 가득참, 버림: " + data);
            return;
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        if(queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
