package com.example.java.basic.extends1.superex;

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
public class Book extends Item{

    private String author;
    private String isbn;

    public Book(String name, int price, String author, String isbn) {
        super(name, price);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Author: " + author + ", ISBN: " + isbn);
    }
}
