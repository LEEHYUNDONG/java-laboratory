package com.example.java.enumeration;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/**
 * @author : lhd
 * @packageName : com.example.java.enumeration
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-06-04         lhd
 */
public class AuthGradeMain2 {

    public static void main(String[] args) {
        EnumSet<AuthGrade> sets = EnumSet.allOf(AuthGrade.class);
        sets.stream().map(AuthGrade::getDescription).forEach(System.out::println);

        EnumMap<AuthGrade, String> maps = new EnumMap(AuthGrade.class);
        maps.put(AuthGrade.ADMIN, "1234");
        maps.forEach((k, v) -> {
            System.out.println("m = " + k + "val :" + v);
        });
        
    }
}
