package com.example.java.lang.advanced._1.thread.control.join;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;
import static com.example.java.lang.advanced._1.thread.util.ThreadUtils.sleep;

public class JoinMainV0 {
    public static void main(String[] args) {
        log("Start main()");
        Thread thread1 = new Thread(new Job(), "thread-1");
        Thread thread2 = new Thread(new Job(), "thread-2");
        thread1.start();
        thread2.start();
        log("end main()");
    }

    static class Job implements Runnable {
        @Override
        public void run() {
            log("작업시작");
            sleep(2000);
            log("작업종료");
        }
    }
}
