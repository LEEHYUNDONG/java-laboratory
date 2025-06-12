package com.example.java.lang.advanced._1.thread.sync;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;
import static com.example.java.lang.advanced._1.thread.util.ThreadUtils.sleep;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {
//        BackAccountV1 bankAccount = new BackAccountV1(1000);
//        BankAccountV2 bankAccount = new BankAccountV2(1000);
        BankAccount bankAccount = new BankAccoutnV3(1000);

        Thread thread1 = new Thread(new WithdrawTask(bankAccount, 800), "withdraw-1");
        Thread thread2 = new Thread(new WithdrawTask(bankAccount, 800), "withdraw-2");

        thread1.start();
        thread2.start();

        sleep(1000); // 검증 완료까지 잠시 대기
        log("t1 state: " + thread1.getState());
        log("t2 state: " + thread2.getState());



        thread1.join();
        thread2.join();

        log("최종 잔액 = " + bankAccount.getBalance());
    }
}
