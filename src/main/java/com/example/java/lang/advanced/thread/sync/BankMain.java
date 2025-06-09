package com.example.java.lang.advanced.thread.sync;

import static com.example.java.lang.advanced.thread.util.MyLogger.log;
import static com.example.java.lang.advanced.thread.util.ThreadUtils.sleep;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {
        BackAccountV1 bankAccount = new BackAccountV1(1000);

        Thread thread1 = new Thread(new WithdrawTask(bankAccount, 800), "withdraw-1");
        Thread thread2 = new Thread(new WithdrawTask(bankAccount, 800), "withdraw-2");

        thread1.start();
        thread1.join();
        sleep(500);
        System.out.println("thread1 state :" + thread1.getState());
        System.out.println("thread2 state :" + thread2.getState());
        thread2.start();
        thread2.join();

        log("최종 잔액 = " + bankAccount.getBalance());
    }
}
