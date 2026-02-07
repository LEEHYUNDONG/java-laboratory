package com.example.java.lang.advanced._1.thread.sync;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class BankAccountV1 implements BankAccount{
    private int balance;

    protected BankAccountV1(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작" + getClass().getSimpleName());
        log("[WITHDRAW START] amount:" +amount + " balance: " + balance);
        if(getBalance() < amount) {
            log("[WITHDRAW FAILED] amount:" +amount + " balance: " + balance);
            return false;
        }
        balance -= amount;
        log("[WITHDRAW SUCCESS] amount:" +amount + " balance: " + balance);


        log("거래 종료");

        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
