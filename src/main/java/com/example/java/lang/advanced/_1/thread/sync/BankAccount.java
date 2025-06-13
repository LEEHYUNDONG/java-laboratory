package com.example.java.lang.advanced._1.thread.sync;

public interface BankAccount {

    boolean withdraw(int amount) throws InterruptedException;

    int getBalance();
}
