package com.example.java.designpattern._05_proxy.before;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubjectImpl implements Subject {


    @Override
    public void request() {
        sleep(1000);
        log.info("Subject Implementation Called..");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
