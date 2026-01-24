package com.example.java.lang.advanced._1.thread.cas.spinlock;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class SpinLockMain {
    public static void main(String[] args) {
//        SpinLockBad spinLock = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                spinLock.lock();
                try {
                    // 임계 영역
                    log("비즈니스 로직 실행");
                } finally {
                    spinLock.unlock();
                    log("락 반납");
                }
            }
        };
        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

    }
}
