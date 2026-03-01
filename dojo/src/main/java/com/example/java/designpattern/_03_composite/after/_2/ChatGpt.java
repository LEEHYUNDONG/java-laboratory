package com.example.java.designpattern._03_composite.after._2;


import org.springframework.stereotype.Component;

@Component
public class ChatGpt implements GenerativeAi2 {

    private static final String name = "ChatGpt";


    @Override
    public boolean isSupport(String name) {
        return ChatGpt.name.equals(name);
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
