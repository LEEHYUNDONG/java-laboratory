package com.example.java.java1.intermediate.object1.equals.ex1;

/**
 * @author : lhd
 * @packageName : com.example.java.java1.intermediate.object1.equals.ex1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-20         lhd
 */
public class RectangleMain {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(100, 20);
        Rectangle rectangle2 = new Rectangle(100, 20);

        System.out.println(rectangle1);
        System.out.println(rectangle2);
        System.out.println(rectangle2==rectangle1);
        System.out.println(rectangle1.equals(rectangle2));
    }
}
