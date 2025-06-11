package com.example.java.lang.advanced.thread.print;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.example.java.lang.advanced.thread.util.MyLogger.log;
import static com.example.java.lang.advanced.thread.util.ThreadUtils.sleep;

public class MyPrinterV1 {

    public static void main(String[] args) {


    }

    static class Printer implements Runnable {
        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();


        @Override
        public void run() {
            while(work){
                if(jobQueue.isEmpty()){
                    continue;
                }

                String job = jobQueue.poll();
                log("출력 시작: " + job + " 대기 문서: " + jobQueue);
                sleep(3000);
                log("출력 완료");
            }

        }

    }
}
