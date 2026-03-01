package com.example.java.designpattern._03_composite.after._1;

public class Claude extends GenerativeAi {

    private static final String name = "Claude";

    public Claude() {
        super(name);
    }

    protected void algorithm() {
        System.out.println(name + " 방식으로 해결해보려 합니다.");
    }

    protected void askQuetionAboutMoreInformation() {
        System.out.println(name + "가 더 필요한 정보가 없는지 제대로 답변했는지 질문합니다.");
    }
}
