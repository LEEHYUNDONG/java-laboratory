package com.example.java.static2;

/**
 * @author : lhd
 * @packageName : com.example.java.static2
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-02         lhd
 */
public class DecoMain1 {
    public static void main(String[] args) {
        String res = "Hello";
        DecoUtil1 decoUtil1 = new DecoUtil1();

        System.out.println("res = " + res);
        System.out.println(decoUtil1.deco(res));

    }
}
