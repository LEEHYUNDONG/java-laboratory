package com.example.java.lang.advanced._1.thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class BoundedQueueV3 implements BoundedQueue{
    private final Queue<String> queue = new ArrayDeque<>();

    private final int capacity;

    public BoundedQueueV3(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void put(String data) {
        while (queue.size() == capacity) {
            log("[put] 큐가 가득 참, 생산자 대기");
            try {
                wait(); // RUNNABLE -> WAITING, 락 반납
                log("[put] 생산자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(data);
        log("[put] 생산자 데이터 저장, notify() 호출");
        notify(); // 대기 스레드, WAIT -> BLOCKED
        //notifyAll(); // 모든 대기 스레드, WAIT -> BLOCKED
    }

    @Override
    public String take() {
        while (queue.isEmpty()) {
            log("[take] 큐에 데이터가 없음, 소비자 대기");
            try {
                wait();
                log("[take] 소비자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String data = queue.poll();
        log("[take] 소비자 데이터 획득, notify() 호출");
        notify(); // 대기 스레드, WAIT -> BLOCKED
        //notifyAll(); // 모든 대기 스레드, WAIT -> BLOCKED
        return data;

    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
