package com.example.java.lang.intermediate.exception;

import java.util.Scanner;

/**
 * @author : lhd
 * @packageName : com.example.java.exception
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-06-05         lhd
 */
public class MainV1 {
    public static void main(String[] args) {
        NetworkServiceV1_1 networkService = new NetworkServiceV1_1();

        Scanner scammer = new Scanner(System.in);

        while (true) {
            System.out.print("전송할 문자 :");
            String input = scammer.nextLine();
            if (input.equals("exit")) {
                break;
            }
            networkService.sendMessage(input);
            System.out.println();

        }
        System.out.println("프로그램을 정상 종료합니다.");
    }
}
