package com.example.java.algorithm.recursive;

public class FibonacciPrintMain {
    public static void fibonacci(int n, int a, int b, int depth) {
        if(depth == n) return;
        System.out.print(a + " ");
        fibonacci(n, b, a + b, depth + 1);

    }

    public static void main(String[] args) {
        fibonacci(10, 1, 1, 0);
    }
}
