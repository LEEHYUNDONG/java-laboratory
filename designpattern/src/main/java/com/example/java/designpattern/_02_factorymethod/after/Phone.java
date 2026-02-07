package com.example.java.designpattern._02_factorymethod.after;

/**
 * @author : lhd
 * @packageName : com.example.java.designpattern._02_factorymethod.after
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-14         lhd
 */


public class Phone {
    public String name;
    public String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
