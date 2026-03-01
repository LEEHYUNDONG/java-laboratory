package com.example.java.lang.advanced._1.thread.collection.simple;

import com.example.java.lang.advanced._1.thread.collection.simple.list.BasicList;
import com.example.java.lang.advanced._1.thread.collection.simple.list.SimpleList;

public class SimpleListMainV1 {
    public static void main(String[] args) {
        SimpleList list = new BasicList();

        list.add("A");
        list.add("B");
        System.out.println("list = " + list);
    }
}
