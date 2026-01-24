package com.example.java.lang.advanced._1.thread.executor;

import java.util.concurrent.Callable;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;
import static com.example.java.lang.advanced._1.thread.util.ThreadUtils.sleep;

public class CallableTask implements Callable<Integer> {

    private String name;
    private int sleepMs = 1000;

    public CallableTask(String name) {
        this.name = name;
    }
    public CallableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public Integer call() {
        log(name + " 실행");
        sleep(sleepMs);
        log(name + " 완료, return = " + sleepMs);
        return sleepMs;
    }
}
