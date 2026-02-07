package com.example.java.lang.advanced._1.thread.start.test;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {
        Runnable runnable1 = new Runnable(){
            @Override
            public void run() {
                while(true) {
                    log("A");
                    try {
                        Thread.sleep(1000); // Simulate some work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // Restore interrupted status
                    }
                }
            }
        };

        Runnable runnable2 = new Runnable(){
            @Override
            public void run() {
                while(true) {
                    log("B");
                    try {
                        Thread.sleep(500); // Simulate some work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // Restore interrupted status
                    }
                }
            }
        };
        
        Thread threadA = new Thread(runnable1, "A printer");
        Thread threadB = new Thread(runnable2, "B printer");
        threadA.start();
        threadB.start();
    }


}
