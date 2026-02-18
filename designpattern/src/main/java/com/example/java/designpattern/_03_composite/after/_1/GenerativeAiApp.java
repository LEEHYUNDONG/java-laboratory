package com.example.java.designpattern._03_composite.after._1;

public class GenerativeAiApp {
    public static void main(String[] args) {
        GenerativeAi claude = new Claude();
        claude.generate();

        GenerativeAi chatGpt = new ChatGpt();
        chatGpt.generate();
    }
}
