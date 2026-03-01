package com.example.java.lang.advanced._1.thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class BoundedQueueV6_4 implements BoundedQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition producerCond = lock.newCondition();
    private final Condition consumerCond = lock.newCondition();

    private final BlockingQueue<String> queue;


    public BoundedQueueV6_4(int capacity) {
        queue = new ArrayBlockingQueue<>(capacity);
    }

    @Override
    public void put(String data) {
        // 대기 시간 설정 가능
        queue.add(data);

    }

    public String take() {
        return queue.remove();

    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
