package com.example.java.designpattern._01_singleton;

/**
 * @author : lhd
 * @packageName : com.example.java.designpattern.singleton
 * @fileName : java
 * @description : singleton pattern - static innerclass
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-08         lhd
 */
public class Data2 {
    private static class Data2Holder {
        private static final Data2 INSTANCE = new Data2();
    }

    public static Data2 getInstance() {
        return Data2Holder.INSTANCE;
    }

}
