package com.example.java.lang.advanced._1.thread.bounded;

public interface BoundedQueue {
    void put(String data) throws InterruptedException;

    String take();
}
