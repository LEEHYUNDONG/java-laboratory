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
public class DecoDataMain {
    public static void main(String[] args) {

        System.out.println("DecoData.staticVar = " + DecoData.staticValue);
        DecoData.staticCall();

        DecoData decoData = new DecoData();
        decoData.instanceCall();
    }
}
