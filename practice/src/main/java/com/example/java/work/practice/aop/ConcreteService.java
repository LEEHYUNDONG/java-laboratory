package com.example.java.work.practice.aop;

import org.springframework.stereotype.Service;

@Service
public class ConcreteService {

    public void doSomething() {
        System.out.println("ConcreteService doSomething with ConcreteService");
    }
}
