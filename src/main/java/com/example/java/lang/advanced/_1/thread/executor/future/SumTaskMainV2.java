package com.example.java.lang.advanced._1.thread.executor.future;

import java.util.concurrent.*;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class SumTaskMainV2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = es.submit(task1);
        Future<Integer> future2 = es.submit(task2);

        future1.get(); // 블로킹 호출, task1의 결과를 기다림
        future2.get(); // 블로킹 호출, task2의 결과를 기다림



        log("task1.reeult = " + task1.result);
        log("task2.result = " + task2.result);

        int sumAll = task1.result + task2.result;
        log("task1 + task2 = " + sumAll);
        log("작업 완료");

        es.close();

    }
    static class SumTask implements Callable<Integer> {
        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }
        @Override
        public Integer call() {
            log("작업 시작");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 result=" + result);
            return sum;
        }
    }
}
