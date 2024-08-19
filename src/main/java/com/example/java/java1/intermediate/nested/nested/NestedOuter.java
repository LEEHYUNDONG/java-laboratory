package com.example.java.java1.intermediate.nested.nested;

/**
 * @author : lhd
 * @packageName : com.example.java.java1.intermediate.nested.nested
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-19         lhd
 */
public class NestedOuter {
    private static int outClassValue = 3;
    private int outInstanceValue = 2;


    static class Nested {
        private int nestendInstanceValue = 1;

        public void print() {
            // 자신의 멤버에 접근
            System.out.println(nestendInstanceValue);

            // 바깥 클래스의 인스턴스 멤버에 접근할 수 없음
            // System.out.println(outInstanceValue);

            // static 변수로는 접근할 수 있음
            System.out.println(NestedOuter.outClassValue);
        }
        
    }
}
