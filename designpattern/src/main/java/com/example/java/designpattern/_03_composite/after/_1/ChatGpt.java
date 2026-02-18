package com.example.java.designpattern._03_composite.after._1;

public class ChatGpt extends GenerativeAi {

    private static final String name = "ChatGpt";

    public ChatGpt() {
        super(name);
    }


    @Override
    public void algorithm() {
        System.out.println("ChatGPT 방식으로 해결해보려 합니다.");
    }

    @Override
    public void askQuetionAboutMoreInformation() {
        System.out.println("ChatGPT가 더 필요한 정보가 없는지 제대로 답변했는지 질문합니다.");
    }
}
