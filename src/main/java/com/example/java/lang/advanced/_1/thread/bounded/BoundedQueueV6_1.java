package com.example.java.lang.advanced._1.thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class BoundedQueueV6_1 implements BoundedQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition producerCond = lock.newCondition();
    private final Condition consumerCond = lock.newCondition();

    private final BlockingQueue<String> queue;


    public BoundedQueueV6_1(int capacity) {
        queue = new ArrayBlockingQueue<>(capacity);
    }

    @Override
    public void put(String data) {
        try {
            queue.put(data);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String take() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString() {
        return queue.toString();
    }
}
