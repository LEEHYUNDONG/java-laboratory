package com.example.java.algorithm.interview;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MaxSubArrayTest {

    private final MaxSubArray solution = new MaxSubArray();

    @Test
    @DisplayName("기본 테스트: [-2,1,-3,4,-1,2,1,-5,4] -> 6")
    void test1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = solution.maxSubArrayBruteForce(nums);

        assertThat(result).isEqualTo(6); // [4,-1,2,1]
    }

    @Test
    @DisplayName("단일 요소: [1] -> 1")
    void test2() {
        int[] nums = {1};

        int result = solution.maxSubArrayBruteForce(nums);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("모두 양수: [5,4,-1,7,8] -> 23")
    void test3() {
        int[] nums = {5, 4, -1, 7, 8};

        int result = solution.maxSubArrayBruteForce(nums);

        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("모두 음수: [-3,-2,-5,-1] -> -1")
    void testAllNegative() {
        int[] nums = {-3, -2, -5, -1};

        int result = solution.maxSubArrayBruteForce(nums);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("양수 하나와 음수들: [-2,-1,3,-1] -> 3")
    void testMixed() {
        int[] nums = {-2, -1, 3, -1};

        int result = solution.maxSubArrayBruteForce(nums);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("큰 배열 테스트")
    void testLargeArray() {
        int[] nums = {1, -1, 1, -1, 1, -1, 1, -1, 1, 100};

        int result = solution.maxSubArrayBruteForce(nums);

        assertThat(result).isEqualTo(101); // 전체 배열의 합
    }

    @Test
    @DisplayName("빈 배열은 예외 발생")
    void testEmptyArray() {
        int[] nums = {};

        assertThrows(IllegalArgumentException.class,
            () -> solution.maxSubArrayBruteForce(nums));
    }

    @Test
    @DisplayName("학생 구현 테스트 (구현 후 주석 해제)")
    void testStudentImplementation() {
        // TODO: 구현 후 아래 주석을 해제하고 테스트하세요
         int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
         int result = solution.maxSubArray(nums);
         assertThat(result).isEqualTo(6);
    }
}
