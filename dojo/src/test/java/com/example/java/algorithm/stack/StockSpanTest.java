package com.example.java.algorithm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("주식 가격 스팬 테스트")
class StockSpanTest {

    private StockSpan solution;

    @BeforeEach
    void setUp() {
        solution = new StockSpan();
    }

    @Test
    @DisplayName("기본 케이스 - 주식 스팬 계산")
    void testCalculateSpanBasic() {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] expected = {1, 1, 1, 2, 1, 4, 6};
        assertThat(solution.calculateSpan(prices)).isEqualTo(expected);
    }

    @Test
    @DisplayName("증가하는 가격 - 모든 스팬이 누적")
    void testCalculateSpanIncreasing() {
        int[] prices = {10, 20, 30, 40, 50};
        int[] expected = {1, 2, 3, 4, 5};
        assertThat(solution.calculateSpan(prices)).isEqualTo(expected);
    }

    @Test
    @DisplayName("감소하는 가격 - 모든 스팬이 1")
    void testCalculateSpanDecreasing() {
        int[] prices = {50, 40, 30, 20, 10};
        int[] expected = {1, 1, 1, 1, 1};
        assertThat(solution.calculateSpan(prices)).isEqualTo(expected);
    }

    @Test
    @DisplayName("단일 가격")
    void testCalculateSpanSingle() {
        int[] prices = {100};
        int[] expected = {1};
        assertThat(solution.calculateSpan(prices)).isEqualTo(expected);
    }

    @Test
    @DisplayName("모든 가격이 같을 때")
    void testCalculateSpanAllSame() {
        int[] prices = {50, 50, 50, 50};
        int[] expected = {1, 2, 3, 4};
        assertThat(solution.calculateSpan(prices)).isEqualTo(expected);
    }

    @Test
    @DisplayName("복잡한 케이스 - 오르락내리락")
    void testCalculateSpanComplex() {
        int[] prices = {31, 27, 14, 21, 30, 22};
        int[] expected = {1, 1, 1, 2, 4, 1};
        assertThat(solution.calculateSpan(prices)).isEqualTo(expected);
    }

    @Test
    @DisplayName("연속 증가 구간 최대 길이 - 기본 케이스")
    void testLongestIncreasingStreakBasic() {
        int[] prices = {1, 2, 3, 2, 3, 4, 5};
        assertThat(solution.longestIncreasingStreak(prices)).isEqualTo(4); // 2,3,4,5
    }

    @Test
    @DisplayName("연속 증가 구간 최대 길이 - 감소하는 배열")
    void testLongestIncreasingStreakDecreasing() {
        int[] prices = {5, 4, 3, 2, 1};
        assertThat(solution.longestIncreasingStreak(prices)).isEqualTo(1);
    }

    @Test
    @DisplayName("연속 증가 구간 최대 길이 - 전체가 증가")
    void testLongestIncreasingStreakAllIncreasing() {
        int[] prices = {1, 2, 3, 4, 5};
        assertThat(solution.longestIncreasingStreak(prices)).isEqualTo(5);
    }

    @Test
    @DisplayName("온라인 주식 스팬 - 예제 케이스")
    void testOnlineStockSpan() {
        StockSpan.OnlineStockSpan stockSpan = new StockSpan.OnlineStockSpan();

        assertThat(stockSpan.next(100)).isEqualTo(1);
        assertThat(stockSpan.next(80)).isEqualTo(1);
        assertThat(stockSpan.next(60)).isEqualTo(1);
        assertThat(stockSpan.next(70)).isEqualTo(2);
        assertThat(stockSpan.next(60)).isEqualTo(1);
        assertThat(stockSpan.next(75)).isEqualTo(4);
        assertThat(stockSpan.next(85)).isEqualTo(6);
    }

    @Test
    @DisplayName("온라인 주식 스팬 - 증가하는 가격")
    void testOnlineStockSpanIncreasing() {
        StockSpan.OnlineStockSpan stockSpan = new StockSpan.OnlineStockSpan();

        assertThat(stockSpan.next(10)).isEqualTo(1);
        assertThat(stockSpan.next(20)).isEqualTo(2);
        assertThat(stockSpan.next(30)).isEqualTo(3);
        assertThat(stockSpan.next(40)).isEqualTo(4);
    }

    @Test
    @DisplayName("온라인 주식 스팬 - 감소하는 가격")
    void testOnlineStockSpanDecreasing() {
        StockSpan.OnlineStockSpan stockSpan = new StockSpan.OnlineStockSpan();

        assertThat(stockSpan.next(40)).isEqualTo(1);
        assertThat(stockSpan.next(30)).isEqualTo(1);
        assertThat(stockSpan.next(20)).isEqualTo(1);
        assertThat(stockSpan.next(10)).isEqualTo(1);
    }

    @Test
    @DisplayName("온라인 주식 스팬 - 같은 가격")
    void testOnlineStockSpanSamePrice() {
        StockSpan.OnlineStockSpan stockSpan = new StockSpan.OnlineStockSpan();

        assertThat(stockSpan.next(50)).isEqualTo(1);
        assertThat(stockSpan.next(50)).isEqualTo(2);
        assertThat(stockSpan.next(50)).isEqualTo(3);
    }
}
