package com.example.java.designpattern._05_proxy.after;

public class ProxyApp {

    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        Proxy proxy = new Proxy(subject);
        ProxyClient proxyClient = new ProxyClient(proxy);

        proxyClient.request();
        proxyClient.request();
        proxyClient.request();
    }
}
