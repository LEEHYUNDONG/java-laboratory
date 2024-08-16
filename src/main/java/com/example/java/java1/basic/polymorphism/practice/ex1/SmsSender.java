package com.example.java.java1.basic.polymorphism.practice.ex1;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.polymorphism.practice.ex1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-16         lhd
 */
public class SmsSender implements Sender{
    @Override
    public void sendMessage(String s) {
        System.out.println("SMS를 발송 :" + s);
    }
}
