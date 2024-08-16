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
public class ConstantMain1 {
    public static void main(String[] args) {
//        System.out.println(Constant.PI);
//        System.out.println(Constant.MAX_USER);
        int currentUserCount = 999;
        process(currentUserCount++);
        process(currentUserCount++);
        process(currentUserCount++);
    }

    private static void process(int currentUserCount) {
        System.out.println("참여자 수:" + currentUserCount);

        if(currentUserCount > Constant.MAX_USER) {
            System.out.println("대기자로 등록합니다.");
        } else {
            System.out.println("게임에 참여합니다.");
        }
    }
}
