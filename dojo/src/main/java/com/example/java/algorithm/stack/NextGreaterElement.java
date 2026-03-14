package com.example.java.algorithm.stack;

/**
 * 다음 큰 원소 (Next Greater Element)
 *
 * 배열의 각 원소에 대해, 오른쪽에 있는 원소 중 자신보다 큰 첫 번째 원소를 찾는 문제
 *
 * 예시:
 * - [4, 5, 2, 25] -> [5, 25, 25, -1]
 * - [13, 7, 6, 12] -> [-1, 12, 12, -1]
 * - [1, 2, 3, 4] -> [2, 3, 4, -1]
 * - [4, 3, 2, 1] -> [-1, -1, -1, -1]
 */
public class NextGreaterElement {

    /**
     * 각 원소의 다음 큰 원소를 찾아 배열로 반환
     *
     * @param nums 입력 배열
     * @return 각 원소의 다음 큰 원소 배열 (없으면 -1)
     */
    public int[] nextGreaterElements(int[] nums) {
        // TODO: Stack을 사용하여 구현하세요
        // 힌트:
        // 1. 스택에 인덱스를 저장
        // 2. 현재 원소가 스택 top의 원소보다 크면 pop하여 결과에 저장
        // 3. 현재 인덱스를 스택에 push
        return new int[nums.length];
    }

    /**
     * 원형 배열에서 다음 큰 원소 찾기
     * 배열의 끝에서 다시 처음으로 연결된다고 가정
     *
     * 예시:
     * - [1, 2, 1] -> [2, -1, 2]
     * - [1, 2, 3, 4, 3] -> [2, 3, 4, -1, 4]
     *
     * @param nums 입력 배열
     * @return 각 원소의 다음 큰 원소 배열 (없으면 -1)
     */
    public int[] nextGreaterElementsCircular(int[] nums) {
        // TODO: 원형 배열을 고려하여 구현하세요
        // 힌트: 배열을 두 번 순회
        return new int[nums.length];
    }

    /**
     * 이전 큰 원소 찾기 (Previous Greater Element)
     * 각 원소에 대해 왼쪽에 있는 원소 중 자신보다 큰 첫 번째 원소를 찾기
     *
     * 예시:
     * - [4, 5, 2, 25] -> [-1, -1, 5, -1]
     * - [13, 7, 6, 12] -> [-1, 13, 7, 13]
     *
     * @param nums 입력 배열
     * @return 각 원소의 이전 큰 원소 배열 (없으면 -1)
     */
    public int[] previousGreaterElements(int[] nums) {
        // TODO: Stack을 사용하여 구현하세요
        return new int[nums.length];
    }

    /**
     * 다음 작은 원소 찾기 (Next Smaller Element)
     *
     * 예시:
     * - [4, 5, 2, 25] -> [2, 2, -1, -1]
     * - [13, 7, 6, 12] -> [7, 6, -1, -1]
     *
     * @param nums 입력 배열
     * @return 각 원소의 다음 작은 원소 배열 (없으면 -1)
     */
    public int[] nextSmallerElements(int[] nums) {
        // TODO: Stack을 사용하여 구현하세요
        return new int[nums.length];
    }
}
