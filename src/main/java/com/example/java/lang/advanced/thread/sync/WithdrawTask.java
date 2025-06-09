package com.example.java.lang.advanced.thread.sync;

public class WithdrawTask implements Runnable{
    private BackAccountV1 bankAccount;
    private int amount;

    public WithdrawTask(BackAccountV1 bankAccount, int amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        bankAccount.withdraw(amount);
    }
}
