package com.example.java.lang.intermediate.nested.inner;

public class InnerOuter {
    private static int outClassValue = 0;
    private int outInstanceValue = 2;

    class Inner {
        private int innerInstacneValue = 1;

        public void print() {

            // 본인 인스턴스에 접근
            System.out.println(innerInstacneValue);

            // 외부 클래스의 인스턴스 멤버에 접근, private 도 접근 가능
            System.out.println(outInstanceValue);

            System.out.println(outClassValue);
        }
    }

}
