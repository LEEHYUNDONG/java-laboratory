package com.example.java.algorithm.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseString {


    public static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int input1 = in.nextInt();

            List<String> result = new ArrayList<>();

            for (int i = input1; i > 0; i--) {
                String str = in.next();

                StringBuilder sb = new StringBuilder(str);
                sb.reverse();
                result.add(sb.toString());

            }

            for (String s : result) {
                System.out.println(s);
            }

            return ;
        }
    }
}
