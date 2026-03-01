package com.example.java.work.practice.aop;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public void doSomething() {
        System.out.println("do something with testServiceImpl");
    }
}
