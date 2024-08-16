package com.example.java.java1.basic.exception;

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
public class MainV0 {
    public static void main(String[] args) {
        NetworkServiceV0 networkServiceV0 = new NetworkServiceV0();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("전송할 문자: ");
            String input = scanner.nextLine();
            if(input.equals("exit")) {
                break;
            }

            networkServiceV0.sendMessage(input);
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료합니다.");
    }
}
