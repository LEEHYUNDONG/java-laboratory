package com.example.java.lang.advanced._1.thread.cas.increment;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger implements IncrementInteger{
    AtomicInteger myAtomicInteger = new AtomicInteger(0);


    @Override
    public void increment() {
        myAtomicInteger.incrementAndGet();
    }

    @Override
    public int get() {
        return myAtomicInteger.get();
    }
}
