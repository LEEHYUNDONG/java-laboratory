package com.example.java.algorithm.recursive;

public class RecursivePrintBinaryMain {

    public static String printBinary(int n) {
        if (n < 2) {
            return String.valueOf(n);
        } else {
            return printBinary(n / 2) + (n % 2);
        }
    }
    public static void main(String[] args) {
        int n = 11;

        System.out.println("printBinary(" + n + ") = " + printBinary(n));
    }
}
