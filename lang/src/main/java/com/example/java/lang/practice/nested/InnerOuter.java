package com.example.java.lang.practice.nested;

public class InnerOuter {

    private int num = 10;

    private static int staticNum = 20;

    public class Inner {

        private int num2 = 30;

        public void print() {
            System.out.println(num);
            System.out.println(staticNum);
            System.out.println("num2 = " + num2);
        }

    }
}
