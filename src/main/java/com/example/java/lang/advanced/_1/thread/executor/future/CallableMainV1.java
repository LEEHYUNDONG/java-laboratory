package com.example.java.lang.advanced._1.thread.executor.future;

import java.util.concurrent.ExecutionException;

public class CallableMainV1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable task = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask, "Thread-1");
        thread.start();
        Integer result = futureTask.get(); // Blocking call until the task is done
        System.out.println("result value = " + result);

    }
}
