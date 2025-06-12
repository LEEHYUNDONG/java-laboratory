package com.example.java.lang.advanced._1.thread.start;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        log(": run()");
    }
}
