package com.example.java.designpattern._04_strategy.after;

public class VolumeLevelTwo implements Volume{
    @Override
    public void volumeUp() {
        System.out.println("볼륨을 두개 올립니다.");
    }

    @Override
    public void volumeDown() {
        System.out.println("볼륨을 두개 줄입니다.");
    }
}
