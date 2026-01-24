package com.example.java.designpattern._03_composite.before;

public class GenerativeAiApp {

    public static void main(String[] args) {
        ChatGpt chatGpt = new ChatGpt();
        chatGpt.generate();

        Claude claude = new Claude();
        claude.generate();
    }
}
