package com.example.java.lang.advanced._1.thread.control.yield;

import static com.example.java.lang.advanced._1.thread.util.ThreadUtils.sleep;

public class YieldMain {
    private static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
//                sleep(1);
                // 현재 스레드의 실행을 양보
                Thread.yield();
            }
        }
    }
}
