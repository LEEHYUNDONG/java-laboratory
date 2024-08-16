package com.example.java.java1.basic.enumeration;

/**
 * @author : lhd
 * @packageName : com.example.java.enumeration
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-06-03         lhd
 */
public class AuthGradeMain1 {
    public static void main(String[] args) {
        AuthGrade[] values = AuthGrade.values();
        for (AuthGrade value : values) {
            printAuthGrade(value);
        }

    }
    private static void printAuthGrade(AuthGrade grade){
        System.out.println(grade.name() + ", level=" + grade.getLevel() + ", 설명=" +grade.getDescription());

    }
}
