package com.example.java.lang.advanced._1.thread.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;
import static com.example.java.lang.advanced._1.thread.util.ThreadUtils.sleep;

public class BankAccoutnV6 implements BankAccount {
    private int balance;

    private final Lock lock = new ReentrantLock();

    protected BankAccoutnV6(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작 " + getClass().getSimpleName());

        try {
            if (!lock.tryLock(500, TimeUnit.MILLISECONDS)) {
                log("[진입 실패] 이미 처리중인 작업이 있습니다.");
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            log("[WITHDRAW START] amount:" + amount + " balance: " + balance);
            if (getBalance() < amount) {
                log("[WITHDRAW FAILED] amount:" + amount + " balance: " + balance);
                return false;
            }
            sleep(1000); // Simulate a delay for demonstration purposes
            balance -= amount;
            log("[WITHDRAW SUCCESS] amount:" + amount + " balance: " + balance);
        } finally {
            lock.unlock();
        }

        log("거래 종료");

        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
