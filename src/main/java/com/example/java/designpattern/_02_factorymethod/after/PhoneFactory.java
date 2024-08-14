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
public interface PhoneFactory {

    public Phone createPhone();


    /**
     * 인터페이스를 만들더라도 확장에 용이하게 default 메서드를 사용한다.
     * 인터페이스를 상속하는 클래스도 해당 메서드를 사용할 수 있음.
     * 추상클래스를 사용하지 않고 인터페이스를 이용하여 개발하도록 많이 변경되었다.
     * 인터페이스는 private method를 가질 수 있는 기능도 막강하다.
     *
     */
    default Phone orderPhone(String name, String email) {
        validate(name, email);

        Phone phone = createPhone();
        sendEmail(name, phone);
        return phone;
    }

    private void sendEmail(String name, Phone phone) {
        System.out.println(phone.getName() + "를(을) 만들었습니다.");
    }

    private void validate(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("폰 이름을 지어주세요");
        } else if (email == null ||  email.isBlank()) {
            throw new IllegalArgumentException("폰 색을 지정해주세요");
        }
    }
}
