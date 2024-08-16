package com.example.java.java1.basic.extends1.superex;

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
public class Movie extends Item{
    private String director;
    private String actor;

    public Movie(String name, int price, String director, String actor) {
        super(name, price);
        this.director = director;
        this.actor = actor;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("- director: " + director + " actor: " + actor);
    }
}
