package com.example.java.algorithm.recursive;

public class RecursiveMain {
    private static void DFS(int n) {
        if(n == 0) return;
        DFS(n - 1);
        System.out.print(n+" ");
    }

    public static void main(String[] args) {
        DFS(3);
    }
}
