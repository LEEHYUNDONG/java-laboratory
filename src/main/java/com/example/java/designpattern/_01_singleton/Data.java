package com.example.java.designpattern._01_singleton;

/**
 * @author : lhd
 * @packageName : com.example.java.designpattern.singleton
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-06         lhd
 */
public class Data {


    // private static Data instance; // 기본
    // private static final Data INSTANCE = new Data(); // 생성자
    // private static final Data instance; // thread sage
    private static volatile Data instance;

    private Data(){}

    // public static synchronized Data getInstance() {}

    public static Data getInstance() {
        /**
         * singleton pattern 구현 - 기본
         */
        //if (instance == null) {
        //    instance = new Data();
        //}

        /**
         * dobule checked locking
         */
        if (instance == null) {
            synchronized (Data.class) {
                if(instance == null) {
                    instance = new Data();
                }
            }

        }
        return instance;
    }


}
