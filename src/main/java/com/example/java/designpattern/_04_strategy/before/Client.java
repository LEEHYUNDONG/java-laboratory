package com.example.java.designpattern._04_strategy.before;

public class Client {

    public static void main(String[] args) {
        VolumeUpAndDown sound = new VolumeUpAndDown();

        sound.volumeUp(1);
        sound.volumeUp(2);
        sound.volumeUp(3);

        sound.volumeDown(1);
        sound.volumeDown(2);
        sound.volumeDown(3);
    }
}
