package com.example.java.designpattern._04_strategy.before;

public class VolumeUpAndDown {

    public void volumeUp(int volume) {
        if (volume == 1) {
            System.out.println("볼륨을 하나 높입니다.");
        } else if(volume == 2) {
            System.out.println("볼륨을 두개 높입니다.");
        } else {
            System.out.println("볼륨을 많이 높입니다.");
        }

    }

    public void volumeDown(int volume) {
        if(volume == 1) {
            System.out.println("볼륨을 하나 줄입니다.");
        } else if (volume == 2) {
            System.out.println("볼륨을 두개 줄입니다.");
        } else {
            System.out.println("볼륨을 많이 줄입니다.");
        }

    }
}
