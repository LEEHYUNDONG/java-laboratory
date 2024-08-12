package com.example.java.designpattern.singleton.ex;

import java.io.Serializable;

/**
 * @author : lhd
 * @packageName : com.example.java.designpattern.singleton.ex
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-12         lhd
 */
public class SerializableFather implements Serializable {

    private SerializableFather(){}

    private static class SerializableFatherHolder {
        private static final SerializableFather INSTANCE = new SerializableFather();
    }

    public static SerializableFather getInstance() {
        return SerializableFatherHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
