package com.example.java.designpattern._03_composite.after._2;

public interface GenerativeAi2 {

    boolean isSupport(String name);

    void askQuetionAboutMoreInformation();

    void algorithm();

    default void generate(String name) {
        defineProblem(name);
        askQuetionAboutMoreInformation();
        algorithm();
        search(name);
        answer(name);

    };

    default void defineProblem(String name) {
        System.out.println(name + "문제를 정의합니다.");
    }

    default void search(String name) {
        System.out.println(name + "문제를 해결하기 위해 검색합니다.");
    }

    default void answer(String name) {
        System.out.println(name + "가 답변합니다.");
    }



}
