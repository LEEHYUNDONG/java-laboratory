package com.example.java.lang.advanced._1.thread.control.print;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class MyPrinterV4 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();
        Scanner userInput = new Scanner(System.in);

        while(true) {
            System.out.println("프린터할 문서를 입력하세요. 종료 (q): ");
            String input = userInput.nextLine();
            if(input.equals("q")) {
                printerThread.interrupt(); // 프린터 스레드가 대기 중일 때 깨우기
                break;
            }
            printer.addJob(input);
        }



    }
    static class Printer implements Runnable {
        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {
                    Thread.yield(); // 다른 스레드에게 CPU를 양보
                    continue;
                }
                try {
                    String job = jobQueue.poll();
                    log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
                    Thread.sleep(3000); //출력에 걸리는 시간
                    log("출력 완료: " + job);
                } catch (InterruptedException e) {
                    log("인터럽트!");
                    break;
                }
            }
            log("프린터 종료");
        }
        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }
}
