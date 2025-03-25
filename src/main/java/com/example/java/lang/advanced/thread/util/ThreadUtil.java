package com.example.java.lang.advanced.thread.util;

public class ThreadUtil implements Runnable{

    Thread thread;

    @Override
    public void run() {
        thread = new Thread(this);
        thread.start();
    }

}
