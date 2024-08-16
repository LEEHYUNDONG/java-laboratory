package com.example.java.java1.basic.final1;

/**
 * @author : lhd
 * @packageName : com.example.java.final1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-06         lhd
 */
public class FinalRefMain {

    public static void main(String[] args) {
        final Data data = new Data();
        // final 값은 변경할 수 없음, 변수의 참조값만 바꿀수 없음.
        // data = new Data();

        // 참조 대상의 값은 변경 가능
        data.value = 10;
        System.out.println("data.value = " + data.value);

        data.value = 20;
        System.out.println("data.value = " + data.value);
    }
}
