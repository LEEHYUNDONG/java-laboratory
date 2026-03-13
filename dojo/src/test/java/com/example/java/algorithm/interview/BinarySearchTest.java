package com.example.java.algorithm.interview;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTest {

    private final BinarySearch solution = new BinarySearch();

    @Test
    @DisplayName("기본 테스트: [-1,0,3,5,9,12], target=9 -> 4")
    void test1() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int result = solution.search(nums, target);

        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("존재하지 않는 값: [-1,0,3,5,9,12], target=2 -> -1")
    void test2() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;

        int result = solution.search(nums, target);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("단일 요소 (존재): [5], target=5 -> 0")
    void testSingleElementFound() {
        int[] nums = {5};
        int target = 5;

        int result = solution.search(nums, target);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("단일 요소 (없음): [5], target=3 -> -1")
    void testSingleElementNotFound() {
        int[] nums = {5};
        int target = 3;

        int result = solution.search(nums, target);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("첫 번째 요소: [1,2,3,4,5], target=1 -> 0")
    void testFirstElement() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 1;

        int result = solution.search(nums, target);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("마지막 요소: [1,2,3,4,5], target=5 -> 4")
    void testLastElement() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;

        int result = solution.search(nums, target);

        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("중간 요소: [1,2,3,4,5], target=3 -> 2")
    void testMiddleElement() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;

        int result = solution.search(nums, target);

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("음수 포함: [-10,-5,0,5,10], target=-5 -> 1")
    void testNegativeNumbers() {
        int[] nums = {-10, -5, 0, 5, 10};
        int target = -5;

        int result = solution.search(nums, target);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("큰 배열: [1-100], target=75 -> 74")
    void testLargeArray() {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i + 1;
        }
        int target = 75;

        int result = solution.search(nums, target);

        assertThat(result).isEqualTo(74);
    }

    @Test
    @DisplayName("재귀 솔루션 테스트: [-1,0,3,5,9,12], target=9 -> 4")
    void testRecursive() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int result = solution.searchRecursive(nums, target);

        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("학생 구현 테스트 (구현 후 주석 해제)")
    void testStudentImplementation() {
        // TODO: 구현 후 아래 주석을 해제하고 테스트하세요
        // int[] nums = {-1, 0, 3, 5, 9, 12};
        // int target = 9;
        // int result = solution.search(nums, target);
        // assertThat(result).isEqualTo(4);
    }
}
