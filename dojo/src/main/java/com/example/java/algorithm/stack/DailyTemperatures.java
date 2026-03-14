package com.example.java.algorithm.stack;

/**
 * 일일 온도 (Daily Temperatures)
 *
 * 매일의 온도가 주어졌을 때, 더 따뜻한 날씨를 위해 며칠을 기다려야 하는지 계산하는 문제
 * 더 따뜻한 날이 없으면 0을 반환
 *
 * 예시:
 * temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
 * 결과 = [1, 1, 4, 2, 1, 1, 0, 0]
 *
 * 설명:
 * - 73: 다음 날(74)이 더 따뜻하므로 1일 기다림
 * - 74: 다음 날(75)이 더 따뜻하므로 1일 기다림
 * - 75: 4일 후(76)가 더 따뜻하므로 4일 기다림
 * - 71: 2일 후(72)가 더 따뜻하므로 2일 기다림
 * - 69: 다음 날(72)이 더 따뜻하므로 1일 기다림
 * - 72: 다음 날(76)이 더 따뜻하므로 1일 기다림
 * - 76: 더 따뜻한 날이 없으므로 0
 * - 73: 더 따뜻한 날이 없으므로 0
 */
public class DailyTemperatures {

    /**
     * 더 따뜻한 날까지 기다려야 하는 일수를 계산
     *
     * @param temperatures 일일 온도 배열
     * @return 각 날짜별로 기다려야 하는 일수 배열
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // TODO: Stack을 사용하여 O(n) 시간 복잡도로 구현하세요
        // 힌트:
        // 1. 스택에 인덱스를 저장
        // 2. 현재 온도가 스택 top의 온도보다 높으면 pop
        // 3. result[stack.pop()] = 현재 인덱스 - pop한 인덱스
        return new int[temperatures.length];
    }

    /**
     * 더 추운 날까지 기다려야 하는 일수를 계산
     *
     * 예시:
     * temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
     * 결과 = [3, 2, 1, 1, 0, 2, 1, 0]
     *
     * @param temperatures 일일 온도 배열
     * @return 각 날짜별로 더 추운 날까지 기다려야 하는 일수 배열
     */
    public int[] dailyColderTemperatures(int[] temperatures) {
        // TODO: Stack을 사용하여 구현하세요
        return new int[temperatures.length];
    }

    /**
     * 온도가 K도 이상 상승하는 날까지 기다려야 하는 일수 계산
     *
     * 예시:
     * temperatures = [30, 40, 50, 60]
     * k = 10
     * 결과 = [1, 1, 1, 0]
     *
     * @param temperatures 일일 온도 배열
     * @param k 온도 차이
     * @return 각 날짜별로 k도 이상 상승하는 날까지 기다려야 하는 일수
     */
    public int[] waitForTemperatureRise(int[] temperatures, int k) {
        // TODO: 구현하세요
        return new int[temperatures.length];
    }
}
