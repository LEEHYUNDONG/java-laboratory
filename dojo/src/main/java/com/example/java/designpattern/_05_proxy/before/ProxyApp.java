package com.example.java.designpattern._05_proxy.before;

public class ProxyApp {

    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        ProxyClient proxyClient = new ProxyClient(subject);

        proxyClient.request();
        proxyClient.request();
        proxyClient.request();
    }
}
