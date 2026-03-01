package com.example.java.designpattern._05_proxy.after;

public class ProxyClient implements Subject {
    private final Subject subject;

    public ProxyClient(Subject subject) {
        this.subject = subject;
    }


    @Override
    public String request() {
        return subject.request();
    }
}
