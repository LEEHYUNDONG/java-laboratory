package com.example.java.lang.advanced._1.thread.start.test;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class StartTest3Main {
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    log("value : " + i);
                    try {
                        Thread.sleep(1000); // Simulate some work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // Restore interrupted status
                    }
                }
            }
        };

        Thread thread = new Thread(runnable, "counter");
        thread.start();
    }


}
