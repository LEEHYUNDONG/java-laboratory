package com.example.java.algorithm.stack;

import java.util.Arrays;

/**
 * 주식 가격 스팬 (Stock Span Problem)
 *
 * 주식의 스팬은 현재 날짜를 포함하여, 현재 가격보다 작거나 같은
 * 연속된 이전 날짜들의 최대 개수를 의미합니다.
 *
 * 예시:
 * 가격: [100, 80, 60, 70, 60, 75, 85]
 * 스팬: [1,   1,  1,  2,  1,  4,  6]
 *
 * 설명:
 * - 100: 이전 날이 없으므로 1
 * - 80: 100 > 80 이므로 1
 * - 60: 80 > 60 이므로 1
 * - 70: 60 <= 70 이므로 2 (60, 70)
 * - 60: 70 > 60 이므로 1
 * - 75: 60, 70, 60 <= 75 이므로 4 (60, 70, 60, 75)
 * - 85: 60, 70, 60, 75, 80 <= 85 이므로 6
 */
public class StockSpan {

    /**
     * 주식 가격 배열에 대한 스팬 계산
     *
     * @param prices 주식 가격 배열
     * @return 각 날짜의 스팬 배열
     */
    public int[] calculateSpan(int[] prices) {
        // TODO: Stack을 사용하여 O(n) 시간 복잡도로 구현하세요
        // 힌트:
        // 1. 스택에 인덱스를 저장
        // 2. 현재 가격보다 작거나 같은 가격들을 스택에서 pop
        // 3. 스팬 = 현재 인덱스 - 스택 top 인덱스
        return new int[prices.length];
    }

    /**
     * 연속으로 증가하는 구간의 최대 길이 구하기
     *
     * 예시:
     * - [1, 2, 3, 2, 3, 4, 5] -> 4 (2, 3, 4, 5)
     * - [5, 4, 3, 2, 1] -> 1
     *
     * @param prices 가격 배열
     * @return 연속 증가 구간의 최대 길이
     */
    public int longestIncreasingStreak(int[] prices) {
        // TODO: 구현하세요
        return 0;
    }

    /**
     * 온라인 주식 스팬 계산기
     * next() 메서드가 호출될 때마다 새로운 가격이 추가되고,
     * 현재 가격의 스팬을 반환합니다.
     */
    public static class OnlineStockSpan {

        public OnlineStockSpan() {
            // TODO: 필요한 자료구조 초기화
        }

        /**
         * 새로운 주식 가격 추가 및 스팬 반환
         *
         * 예시:
         * OnlineStockSpan stockSpan = new OnlineStockSpan();
         * stockSpan.next(100); // 1
         * stockSpan.next(80);  // 1
         * stockSpan.next(60);  // 1
         * stockSpan.next(70);  // 2
         * stockSpan.next(60);  // 1
         * stockSpan.next(75);  // 4
         * stockSpan.next(85);  // 6
         *
         * @param price 새로운 주식 가격
         * @return 현재 가격의 스팬
         */
        public int next(int price) {
            // TODO: Stack을 사용하여 구현하세요
            return 0;
        }
    }

    public static void main(String[] args) {
        StockSpan solution = new StockSpan();

        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = solution.calculateSpan(prices);

        System.out.println("가격: " + Arrays.toString(prices));
        System.out.println("스팬: " + Arrays.toString(spans));
        System.out.println("예상: [1, 1, 1, 2, 1, 4, 6]");
    }
}
