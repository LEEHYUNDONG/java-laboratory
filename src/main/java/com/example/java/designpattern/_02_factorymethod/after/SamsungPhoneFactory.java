package com.example.java.designpattern._02_factorymethod.after;

/**
 * @author : lhd
 * @packageName : com.example.java.designpattern._02_factorymethod
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-14         lhd
 */
public class SamsungPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new SamsungPhone();
    }
}
