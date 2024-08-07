package com.example.java.designpattern.singleton;

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

//    private static Data instance;
    private static final Data INSTANCE = new Data();

    private Data(){}

    // public static synchronized Data getInstance() {}

    public static Data getInstance() {
//        if(instance == null) {
//            instance = new Data();
//        }
//        return instance;
        return INSTANCE;
    }


}
