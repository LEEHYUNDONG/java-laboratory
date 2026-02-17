package com.example.java.algorithm.dfs;

import java.util.Scanner;

public class PartialSum {
    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;

    public void DFS(int L, int sum, int[] arr) {
        if(flag)
            return;
        if(L == sum) {
            answer = "YES";
            flag = true;
            return;
        }
        for(int i = 0 ; i < arr.length ; i++) {
            DFS(L, sum + arr[i], arr);
        }


    }

    public static void main(String[] args) {
        PartialSum ps = new PartialSum();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            total += arr[i];
        }
        ps.DFS(0, total, arr);
        System.out.println(answer);
    }


}
