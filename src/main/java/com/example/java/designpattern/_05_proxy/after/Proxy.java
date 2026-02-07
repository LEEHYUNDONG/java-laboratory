package com.example.java.designpattern._05_proxy.after;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Proxy implements Subject {

    private final Subject subject;

    private String data;

    public Proxy(Subject subject) {
        this.subject = subject;
    }


    @Override
    public String request() {
        log.info("Proxy called..");
        if(data == null) {
            data = subject.request();
        }

        return data;
    }
}
