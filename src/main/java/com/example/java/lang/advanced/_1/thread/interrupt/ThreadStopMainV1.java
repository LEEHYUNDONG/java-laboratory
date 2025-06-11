package com.example.java.lang.advanced.thread.interrupt;


import static com.example.java.lang.advanced.thread.util.MyLogger.log;
import static com.example.java.lang.advanced.thread.util.ThreadUtils.sleep;

public class ThreadStopMainV1 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "worker");

        thread.start();

        sleep(4000);
        log("작업 중단 지시 runFlag=false");
        task.runFlag = false;

    }

    static class MyTask implements Runnable {
        volatile boolean runFlag = true;

        @Override
        public void run() {
            while(runFlag) {
                log("작업중...");
                sleep(1000);
            }
            log("작업정리");
            log("작업종료");
        }
    }
}
