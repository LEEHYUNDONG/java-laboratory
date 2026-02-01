package com.example.java.designpattern._04_strategy.after;

public class Client {

    public static void main(String[] args) {
        VolumeUpAndDown volumeUpAndDown = new VolumeUpAndDown();

        volumeUpAndDown.volumeUp(new VolumeLevelOne());
        volumeUpAndDown.volumeUp(new VolumeLevelTwo());
        volumeUpAndDown.volumeUp(new MaxVolume());
    }
}
