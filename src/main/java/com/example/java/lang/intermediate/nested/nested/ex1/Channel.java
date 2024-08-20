package com.example.java.lang.intermediate.nested.nested.ex1;

/**
 * @author : lhd
 * @packageName : com.example.java.java1.intermediate.nested.nested.ex1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-19         lhd
 */
public class Channel {

    public void sendSignal(String message) {
        ChannelMessage channelMessage = new ChannelMessage();
        channelMessage.sendMessage(message);
    }

    private static class ChannelMessage {
        private String message;

        private void sendMessage(String message) {
            System.out.println("message = " + message);
        }
    }
}
