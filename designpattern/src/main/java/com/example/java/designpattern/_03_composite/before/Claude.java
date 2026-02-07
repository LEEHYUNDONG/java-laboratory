package com.example.java.designpattern._03_composite.before;

public class Claude {


    public void generate() {
        defineProblem();
        search();
        claudeAlgorithm();
        answer();
        askQuetionAboutMoreInformation();
    }

    protected void defineProblem() {
        System.out.println("Claude가 문제를 정의합니다.");
    }

    protected void search() {
        System.out.println("Claude가 검색을 시도합니다.");
    }

    protected void answer() {
        System.out.println("Claude가 문제의 답변합니다.");
    }

    protected void claudeAlgorithm() {
        System.out.println("Claude 방식으로 해결해보려 합니다.");
    }

    protected void askQuetionAboutMoreInformation() {
        System.out.println("Claude가 더 필요한 정보가 없는지 제대로 답변했는지 질문합니다.");
    }
}
