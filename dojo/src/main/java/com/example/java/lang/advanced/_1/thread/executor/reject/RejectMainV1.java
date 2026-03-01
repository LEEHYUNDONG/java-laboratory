package com.example.java.lang.advanced._1.thread.executor.reject;

import com.example.java.lang.advanced._1.thread.executor.RunnableTask;

import java.util.concurrent.*;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class RejectMainV1 {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new ThreadPoolExecutor.AbortPolicy());
        es.submit(new RunnableTask("task1"));

        try {
            es.submit(new RunnableTask("task2"));
        } catch (RejectedExecutionException e) {
            log("요청 초과");
// 포기, 다시 시도 등 다양한 고민을 하면 됨
            log(e);
        }
        es.close();
    }
}
