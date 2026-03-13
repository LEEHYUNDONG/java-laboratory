package com.example.java.algorithm.interview;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();

    @Test
    @DisplayName("기본 테스트: [2,7,11,15], target=9 -> [0,1]")
    void test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum.twoSumSolution(nums, target);

        assertThat(result).containsExactlyInAnyOrder(0, 1);
    }

    @Test
    @DisplayName("테스트: [3,2,4], target=6 -> [1,2]")
    void test2() {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = twoSum.twoSumSolution(nums, target);

        assertThat(result).containsExactlyInAnyOrder(1, 2);
    }

    @Test
    @DisplayName("테스트: [3,3], target=6 -> [0,1]")
    void test3() {
        int[] nums = {3, 3};
        int target = 6;

        int[] result = twoSum.twoSumSolution(nums, target);

        assertThat(result).containsExactlyInAnyOrder(0, 1);
    }

    @Test
    @DisplayName("음수 포함 테스트: [-1,-2,-3,-4,-5], target=-8 -> [2,4]")
    void testNegativeNumbers() {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;

        int[] result = twoSum.twoSumSolution(nums, target);

        assertThat(result).containsExactlyInAnyOrder(2, 4);
    }

    @Test
    @DisplayName("해가 없는 경우 예외 발생")
    void testNoSolution() {
        int[] nums = {1, 2, 3};
        int target = 10;

        assertThrows(IllegalArgumentException.class,
            () -> twoSum.twoSumSolution(nums, target));
    }

    @Test
    @DisplayName("학생 구현 테스트 (구현 후 주석 해제)")
    void testStudentImplementation() {
        // TODO: 구현 후 아래 주석을 해제하고 테스트하세요
        // int[] nums = {2, 7, 11, 15};
        // int target = 9;
        // int[] result = twoSum.twoSum(nums, target);
        // assertThat(result).containsExactlyInAnyOrder(0, 1);
    }
}
