package com.example.java.basic.wrapper;

/**
 * @author : lhd
 * @packageName : com.example.java.wrapper
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-05-31         lhd
 */
public class MyIntegerMethodMain0 {
    public static void main(String[] args) {

        int val = 10;
        int target = 20;
        printByComparison(compareTo(val, target), val, target);
    }

    public static int compareTo(int val, int target) {
        if (val < target) {
            return -1;
        } else if (val > target) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void printByComparison(int res, int val, int target) {
        switch (res) {
            case 1:
                System.out.printf("%d가 %d 보다 큽니다.%n", val, target);
                break;
            case -1:
                System.out.printf("%d가 %d 보다 작습니다.%n", val, target);
                break;
            default:
                System.out.printf("%d와 %d는 값이 같습니다.%n", val, target);
                break;
        }
    }
}
