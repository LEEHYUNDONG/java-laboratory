package com.example.java.lang.advanced.thread.start;

import static com.example.java.lang.advanced.thread.util.MyLogger.log;

public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        log(": run()");
    }
}
