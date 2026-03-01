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
public class App {

    public static void main(String[] args) {
        print(new IphoneFactory(), "lee", "hd.lee@mail.com");
        print(new SamsungPhoneFactory(), "lee", "hd.lee@mail.com");

    }

    private static void print(PhoneFactory factory, String name, String email) {
        System.out.println(factory.orderPhone(name, email).toString());
    }
}
