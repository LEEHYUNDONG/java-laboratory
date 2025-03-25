package com.example.java.lang.advanced.thread.sync;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BackAccountV1 implements BankAccount{
    private int balance;

    protected BackAccountV1(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log.info("거래 시작" + getClass().getSimpleName());
        log.info("WITHDRAW amount: {} balance: {}", amount, getBalance());
        if(getBalance() < amount) {
            log.info("[WITHDRAW FAILED] amount: {} balance: {}", amount, balance);
            return false;
        }
        balance -= amount;
        log.info("[WITHDRAW SUCCESS] amount: {} balance: {}", amount, balance);

        log.info("거래 종료");

        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
