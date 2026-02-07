package com.example.java.designpattern._03_composite.after;

public abstract class GenerativeAi {

    private final String name;

    public GenerativeAi(String name) {
        this.name = name;
    }

    public final void generate() {
        defineProblem();
        search();
        algorithm();
        answer();
        askQuetionAboutMoreInformation();
    }

    final void defineProblem() {
        System.out.println(name + "문제를 정의합니다.");
    }

    final void search() {
        System.out.println(name + "문제를 해결하기 위해 검색합니다.");
    }

    final void answer() {
        System.out.println(name + "가 답변합니다.");
    }

    protected abstract void algorithm();

    protected abstract void askQuetionAboutMoreInformation();

}
