package com.example.java.java1.basic.extends1.superex;

import lombok.Getter;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.extends1.superex
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-08         lhd
 */
public class Item {
    private String name;
    @Getter
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println("이름:" + this.name + " 가격:" + this.price);
    }

}
