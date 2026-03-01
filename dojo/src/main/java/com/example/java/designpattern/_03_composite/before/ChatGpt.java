package com.example.java.designpattern._03_composite.before;

public class ChatGpt {

    /*
    1. 문제 정의
    2. 검색
    3. 답변 제공
    4. 질문
     */

    public void generate() {
        defineProblem();
        search();
        chatGPTAlgorithm();
        answer();
        askQuetionAboutMoreInformation();
    }

    protected void defineProblem() {
        System.out.println("ChatGPT가 문제를 정의합니다.");
    }

    protected void search() {
        System.out.println("ChatGPT가 검색을 시도합니다.");
    }

    protected void answer() {
        System.out.println("ChatGPT가 문제의 답변합니다.");
    }

    protected void askQuetionAboutMoreInformation() {
        System.out.println("ChatGPT가 더 필요한 정보가 없는지 제대로 답변했는지 질문합니다.");
    }
    protected void chatGPTAlgorithm() {
        System.out.println("ChatGPT 방식으로 해결해보려 합니다.");
    }
}
