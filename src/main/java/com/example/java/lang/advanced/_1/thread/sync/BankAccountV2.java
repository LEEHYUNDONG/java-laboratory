package com.example.java.lang.advanced._1.thread.sync;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;
import static com.example.java.lang.advanced._1.thread.util.ThreadUtils.sleep;

public class BankAccountV2 implements BankAccount{
    private int balance;

    protected BankAccountV2(int balance) {
        this.balance = balance;
    }

    @Override
    public synchronized boolean withdraw(int amount) {
        log("거래 시작 " + getClass().getSimpleName());
        log("[WITHDRAW START] amount:" +amount + " balance: " + balance);
        if(getBalance() < amount) {
            log("[WITHDRAW FAILED] amount:" +amount + " balance: " + balance);
            return false;
        }
        sleep(2000); // Simulate a delay for demonstration purposes
        balance -= amount;
        log("[WITHDRAW SUCCESS] amount:" +amount + " balance: " + balance);


        log("거래 종료");

        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
