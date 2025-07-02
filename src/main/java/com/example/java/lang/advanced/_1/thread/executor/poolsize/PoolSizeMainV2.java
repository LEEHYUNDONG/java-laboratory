package com.example.java.lang.advanced._1.thread.executor.poolsize;

import com.example.java.lang.advanced._1.thread.executor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.example.java.lang.advanced._1.thread.executor.ExecutorUtils.printState;
import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class PoolSizeMainV2 {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(2);

        log("pool 생성");
        printState(es);

        for(int i = 0; i < 10; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);

        }
        es.close();
        log("pool 종료");
    }
}
