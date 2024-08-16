package com.example.java.basic.polymorphism.practice.ex1;

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
public class EmailSender implements Sender{
    @Override
    public void sendMessage(String s) {
        System.out.println("메일을 발송 :" + s);
    }
}
