package com.example.java.lang.advanced._1.thread.volatile1;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;
import static com.example.java.lang.advanced._1.thread.util.ThreadUtils.sleep;

public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " +  task.runFlag);
        log("main 종료");


    }

    static class MyTask implements Runnable {
//        boolean runFlag = true;
        volatile boolean runFlag = true; // volatile 키워드를 사용하여 runFlag를 선언
        @Override
        public void run() {
            log("task 시작");
            while(runFlag)  {

            }
            log("task 종료");

        }
    }
}
