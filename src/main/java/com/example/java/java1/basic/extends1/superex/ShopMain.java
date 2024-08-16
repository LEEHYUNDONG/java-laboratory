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
public class ShopMain {
    public static void main(String[] args) {

        Book book = new Book("JAVA", 10000, "HAN", "12345");
        Album album = new Album("앨범1", 150000, "seo");
        Movie movie = new Movie("영화1", 104000, "감독1", "배우1");

        book.print();
        album.print();
        movie.print();

        int sum = book.getPrice() + album.getPrice() + movie.getPrice();
        System.out.println("sum = " + sum);

    }
}
