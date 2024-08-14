package com.example.java.designpattern._02_factorymethod.before;

/**
 * @author : lhd
 * @packageName : com.example.java.designpattern.factorymethod.ex
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-12         lhd
 */
public abstract class Phone {
    public void call() {
        System.out.println("call someone ...");
    }
    public void on() {
        System.out.println("turn on ...");
    }
    public void off() {
        System.out.println("turn off ...");
    }
    abstract void ring();
}
