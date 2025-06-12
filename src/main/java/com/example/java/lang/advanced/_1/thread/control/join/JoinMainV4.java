package com.example.java.lang.advanced._1.thread.control.join;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;
import static com.example.java.lang.advanced._1.thread.util.ThreadUtils.sleep;

public class JoinMainV4 {
    public static void main(String[] args) throws InterruptedException {
        log("Start main()");
        SumTask task1 = new SumTask(1, 50);

        Thread thread1 = new Thread(task1, "thread-1");
        thread1.start();
        thread1.join(1000); // Wait for thread1 to finish
        log("task1.result = " + task1.result);

        int res = task1.result;
        log("end res = " + res);
        log("end main()");
    }

    static class SumTask implements Runnable {

        int startVal;
        int endVal;
        int result = 0;

        public SumTask(int startVal, int endVal) {
            this.startVal = startVal;
            this.endVal = endVal;
        }

        @Override
        public void run() {
            log("작업시작");
            sleep(2000);

            for (int i = startVal; i <= endVal; i++) {
                result += i;
            }
            log("작업종료 result = " + result);
        }
    }
}
