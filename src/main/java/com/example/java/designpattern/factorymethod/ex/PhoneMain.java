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
public class PhoneMain {

    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        Phone phone1 = factory.createPhone("iphone");
        phone1.on();
        phone1.call();
        phone1.ring();
        phone1.off();

        Phone phone2 = factory.createPhone("samsung");
        phone2.on();
        phone2.call();
        phone2.ring();
        phone2.off();

        Phone phone3 = factory.createPhone("google");
        phone3.on();
        phone3.call();
        phone3.ring();
        phone3.off();
    }
}
