package com.example.java.designpattern._04_strategy.after;

public class MaxVolume implements Volume{
    @Override
    public void volumeUp() {
        System.out.println("볼륨을 가장 키웁니다.!!!");
    }

    @Override
    public void volumeDown() {
        System.out.println("볼륨을 가장 줄입니다....");
    }
}
