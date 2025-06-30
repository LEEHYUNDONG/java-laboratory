package com.example.java.lang.advanced._1.thread.executor.future;

import java.util.concurrent.*;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;
import static com.example.java.lang.advanced._1.thread.util.ThreadUtils.sleep;

public class FutureCancelMain {
    private static boolean mayInterruptIfRunning = false; // true: 현재 실행 중인 스레드 인터럽트, false: 대기 중인 스레드 취소
//    private static boolean mayInterruptIfRunning = true; // true: 현재 실행 중인 스레드 인터럽트, false: 대기 중인 스레드 취소

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> future = es.submit(new MyTask());
        log("Future.state: " + future.state());
        // 일정 시간 후 취소 시도
        sleep(3000);

        boolean cancelResult1 = future.cancel(mayInterruptIfRunning);
        log("Future.state: " + future.state());
        log("cancel(" + mayInterruptIfRunning + ") result: " + cancelResult1);

        // 결과 확인
        try {
            log("Future result: " + future.get());
        } catch (CancellationException e) { // 런타임 예외
            log("Future는 이미 취소 되었습니다.");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
// Executor 종료
        es.close();

    }

    static class MyTask implements Callable<String> {

        @Override
        public String call(){
            try{
                for(int i = 0;i < 10;i++){
                    log("작업 중: " + i);
                    Thread.sleep(1000); // 1초 대기
                }
            } catch (InterruptedException e) {
                log("인터럽트 발생");
                return "Interrupted";
            }
            return "Completed";
        }
    }
}
