package com.example.java.designpattern._04_strategy.after;

public class VolumeLevelOne implements Volume{
    @Override
    public void volumeUp() {
        System.out.println("볼륨을 한개 올립니다.");
    }

    @Override
    public void volumeDown() {
        System.out.println("볼륨을 하나 줄입니다.");
    }
}
