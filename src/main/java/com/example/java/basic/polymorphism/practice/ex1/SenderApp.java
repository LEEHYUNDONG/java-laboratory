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
public class SenderApp {
    public static void main(String[] args) {
        Sender[] senders = {new EmailSender(), new SmsSender(), new FaceBookSender()};
        for (Sender sender : senders) {
            sender.sendMessage("환영합니다.");
        }
    }
}
