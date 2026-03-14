package com.example.java.algorithm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("일일 온도 테스트")
class DailyTemperaturesTest {

    private DailyTemperatures solution;

    @BeforeEach
    void setUp() {
        solution = new DailyTemperatures();
    }

    @Test
    @DisplayName("기본 케이스 - 일일 온도")
    void testDailyTemperaturesBasic() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
        assertThat(solution.dailyTemperatures(temperatures)).isEqualTo(expected);
    }

    @Test
    @DisplayName("증가하는 온도 - 매일 다음 날이 더 따뜻함")
    void testDailyTemperaturesIncreasing() {
        int[] temperatures = {30, 40, 50, 60};
        int[] expected = {1, 1, 1, 0};
        assertThat(solution.dailyTemperatures(temperatures)).isEqualTo(expected);
    }

    @Test
    @DisplayName("감소하는 온도 - 더 따뜻한 날이 없음")
    void testDailyTemperaturesDecreasing() {
        int[] temperatures = {60, 50, 40, 30};
        int[] expected = {0, 0, 0, 0};
        assertThat(solution.dailyTemperatures(temperatures)).isEqualTo(expected);
    }

    @Test
    @DisplayName("단일 온도")
    void testDailyTemperaturesSingle() {
        int[] temperatures = {30};
        int[] expected = {0};
        assertThat(solution.dailyTemperatures(temperatures)).isEqualTo(expected);
    }

    @Test
    @DisplayName("같은 온도가 계속될 때")
    void testDailyTemperaturesSameTemp() {
        int[] temperatures = {30, 30, 30, 30};
        int[] expected = {0, 0, 0, 0};
        assertThat(solution.dailyTemperatures(temperatures)).isEqualTo(expected);
    }

    @Test
    @DisplayName("복잡한 케이스")
    void testDailyTemperaturesComplex() {
        int[] temperatures = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] expected = {8, 1, 5, 4, 3, 2, 1, 1, 0, 0};
        assertThat(solution.dailyTemperatures(temperatures)).isEqualTo(expected);
    }

    @Test
    @DisplayName("더 추운 날 - 기본 케이스")
    void testDailyColderTemperaturesBasic() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {3, 2, 1, 1, 0, 2, 1, 0};
        assertThat(solution.dailyColderTemperatures(temperatures)).isEqualTo(expected);
    }

    @Test
    @DisplayName("더 추운 날 - 증가하는 온도")
    void testDailyColderTemperaturesIncreasing() {
        int[] temperatures = {30, 40, 50, 60};
        int[] expected = {0, 0, 0, 0};
        assertThat(solution.dailyColderTemperatures(temperatures)).isEqualTo(expected);
    }

    @Test
    @DisplayName("더 추운 날 - 감소하는 온도")
    void testDailyColderTemperaturesDecreasing() {
        int[] temperatures = {60, 50, 40, 30};
        int[] expected = {1, 1, 1, 0};
        assertThat(solution.dailyColderTemperatures(temperatures)).isEqualTo(expected);
    }

    @Test
    @DisplayName("온도 K도 상승 - 기본 케이스")
    void testWaitForTemperatureRiseBasic() {
        int[] temperatures = {30, 40, 50, 60};
        int k = 10;
        int[] expected = {1, 1, 1, 0};
        assertThat(solution.waitForTemperatureRise(temperatures, k)).isEqualTo(expected);
    }

    @Test
    @DisplayName("온도 K도 상승 - K가 큰 경우")
    void testWaitForTemperatureRiseLargeK() {
        int[] temperatures = {30, 35, 40, 50};
        int k = 15;
        int[] expected = {3, 2, 1, 0};
        assertThat(solution.waitForTemperatureRise(temperatures, k)).isEqualTo(expected);
    }

    @Test
    @DisplayName("온도 K도 상승 - 상승하지 않는 경우")
    void testWaitForTemperatureRiseNoRise() {
        int[] temperatures = {30, 35, 33, 34};
        int k = 10;
        int[] expected = {0, 0, 0, 0};
        assertThat(solution.waitForTemperatureRise(temperatures, k)).isEqualTo(expected);
    }

    @Test
    @DisplayName("온도 K도 상승 - 복잡한 케이스")
    void testWaitForTemperatureRiseComplex() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int k = 5;
        int[] expected = {6, 5, 4, 3, 2, 1, 0, 0};
        assertThat(solution.waitForTemperatureRise(temperatures, k)).isEqualTo(expected);
    }
}
