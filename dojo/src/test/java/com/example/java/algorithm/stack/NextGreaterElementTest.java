package com.example.java.algorithm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("다음 큰 원소 테스트")
class NextGreaterElementTest {

    private NextGreaterElement solution;

    @BeforeEach
    void setUp() {
        solution = new NextGreaterElement();
    }

    @Test
    @DisplayName("기본 케이스 - 다음 큰 원소")
    void testNextGreaterElementsBasic() {
        int[] nums = {4, 5, 2, 25};
        int[] expected = {5, 25, 25, -1};
        assertThat(solution.nextGreaterElements(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("다음 큰 원소 - 감소하는 배열")
    void testNextGreaterElementsDecreasing() {
        int[] nums = {4, 3, 2, 1};
        int[] expected = {-1, -1, -1, -1};
        assertThat(solution.nextGreaterElements(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("다음 큰 원소 - 증가하는 배열")
    void testNextGreaterElementsIncreasing() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {2, 3, 4, -1};
        assertThat(solution.nextGreaterElements(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("다음 큰 원소 - 단일 원소")
    void testNextGreaterElementsSingle() {
        int[] nums = {1};
        int[] expected = {-1};
        assertThat(solution.nextGreaterElements(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("다음 큰 원소 - 복잡한 케이스")
    void testNextGreaterElementsComplex() {
        int[] nums = {13, 7, 6, 12};
        int[] expected = {-1, 12, 12, -1};
        assertThat(solution.nextGreaterElements(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("원형 배열 - 기본 케이스")
    void testNextGreaterElementsCircularBasic() {
        int[] nums = {1, 2, 1};
        int[] expected = {2, -1, 2};
        assertThat(solution.nextGreaterElementsCircular(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("원형 배열 - 복잡한 케이스")
    void testNextGreaterElementsCircularComplex() {
        int[] nums = {1, 2, 3, 4, 3};
        int[] expected = {2, 3, 4, -1, 4};
        assertThat(solution.nextGreaterElementsCircular(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("원형 배열 - 모든 원소가 같은 경우")
    void testNextGreaterElementsCircularAllSame() {
        int[] nums = {5, 5, 5, 5};
        int[] expected = {-1, -1, -1, -1};
        assertThat(solution.nextGreaterElementsCircular(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("이전 큰 원소 - 기본 케이스")
    void testPreviousGreaterElementsBasic() {
        int[] nums = {4, 5, 2, 25};
        int[] expected = {-1, -1, 5, -1};
        assertThat(solution.previousGreaterElements(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("이전 큰 원소 - 증가하는 배열")
    void testPreviousGreaterElementsIncreasing() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {-1, -1, -1, -1};
        assertThat(solution.previousGreaterElements(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("이전 큰 원소 - 복잡한 케이스")
    void testPreviousGreaterElementsComplex() {
        int[] nums = {13, 7, 6, 12};
        int[] expected = {-1, 13, 7, 13};
        assertThat(solution.previousGreaterElements(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("다음 작은 원소 - 기본 케이스")
    void testNextSmallerElementsBasic() {
        int[] nums = {4, 5, 2, 25};
        int[] expected = {2, 2, -1, -1};
        assertThat(solution.nextSmallerElements(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("다음 작은 원소 - 증가하는 배열")
    void testNextSmallerElementsIncreasing() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {-1, -1, -1, -1};
        assertThat(solution.nextSmallerElements(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("다음 작은 원소 - 감소하는 배열")
    void testNextSmallerElementsDecreasing() {
        int[] nums = {4, 3, 2, 1};
        int[] expected = {3, 2, 1, -1};
        assertThat(solution.nextSmallerElements(nums)).isEqualTo(expected);
    }

    @Test
    @DisplayName("다음 작은 원소 - 복잡한 케이스")
    void testNextSmallerElementsComplex() {
        int[] nums = {13, 7, 6, 12};
        int[] expected = {7, 6, -1, -1};
        assertThat(solution.nextSmallerElements(nums)).isEqualTo(expected);
    }
}
