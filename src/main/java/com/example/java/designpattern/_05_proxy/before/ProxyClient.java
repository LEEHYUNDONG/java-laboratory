package com.example.java.designpattern._05_proxy.before;

public class ProxyClient implements Subject{
    private final Subject subject;

    public ProxyClient(Subject subject) {
        this.subject = subject;
    }


    @Override
    public void request() {
        subject.request();
    }
}
