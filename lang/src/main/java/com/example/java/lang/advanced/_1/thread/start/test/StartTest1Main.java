package com.example.java.lang.advanced._1.thread.start.test;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class StartTest1Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new CounterThread());
        thread.start();
    }

    static class CounterThread extends Thread {
        private int count = 0;

        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    count++;
                    Thread.sleep(1000); // Simulate some work
                    log("value : " + count);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
    }

}
