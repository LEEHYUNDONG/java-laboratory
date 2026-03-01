package com.example.java.lang.advanced._1.thread.sync.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {
    private final Lock nonFairLock = new ReentrantLock();

    private final Lock fairLock = new ReentrantLock(true);

    public void nonFairLockTest() {
        nonFairLock.lock();
        try{
            // 임계
        } finally {
            nonFairLock.unlock();
        }
    }

    public void fairLockTest() {
        fairLock.lock();
        try{
            // 임계
        } finally {
            fairLock.unlock();
        }
    }

}
