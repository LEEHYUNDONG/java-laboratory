package com.example.java.lang.advanced.thread.util;

import static com.example.java.lang.advanced.thread.util.MyLogger.log;

public abstract class ThreadUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("인터럽트 발생, " + e.getMessage());
            e.printStackTrace();
        }
    }

}
