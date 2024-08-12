package com.example.java.designpattern.factorymethod.ex;

/**
 * @author : lhd
 * @packageName : com.example.java.designpattern.factorymethod.ex
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-12         lhd
 */
public class PhoneFactory {

    public Phone createPhone(String type) {
        Phone phone = null;
        switch (type) {
            case "iphone":
                phone = new Iphone();
                break;
            case "samsung":
                phone = new Samsung();
                break;
            case "google":
                phone = new Google();
                break;
        }
        return phone;
    }

}
