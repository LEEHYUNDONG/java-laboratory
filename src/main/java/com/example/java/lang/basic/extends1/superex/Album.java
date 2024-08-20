package com.example.java.lang.basic.extends1.superex;

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
public class Album extends Item{
    private String artist;

    public Album(String name, int price, String artist) {
        super(name, price);
        this.artist = artist;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("- Artist: " + artist);
    }

}
