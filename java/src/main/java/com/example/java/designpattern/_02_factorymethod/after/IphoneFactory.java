package com.example.java.designpattern._02_factorymethod.after;

/**
 * @author : lhd
 * @packageName : com.example.java.designpattern._02_factorymethod.after
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-14         lhd
 */
public class IphoneFactory implements PhoneFactory{

    @Override
    public Phone createPhone() {
        return new Iphone();
    }
}
