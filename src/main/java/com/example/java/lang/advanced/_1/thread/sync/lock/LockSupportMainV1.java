package com.example.java.lang.advanced._1.thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class LockSupportMainV1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTask(), "Thread-1");
    }

    static class ParkTask implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}

