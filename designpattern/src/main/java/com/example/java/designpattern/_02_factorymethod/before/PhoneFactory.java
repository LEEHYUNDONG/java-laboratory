package com.example.java.designpattern._02_factorymethod.before;

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
                //만약에 객체나 제품이 추가되면 아래에 코드를 추가해야함(변경에 열려있음)
            // 변경에 닫혀있는 코드로 고쳐야한다.
        }
        return phone;
    }

}
