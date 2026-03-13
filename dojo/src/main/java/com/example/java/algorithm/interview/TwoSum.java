package com.example.java.algorithm.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제: Two Sum
 *
 * 정수 배열 nums와 정수 target이 주어집니다.
 * 배열에서 두 수를 더해서 target이 되는 두 수의 인덱스를 반환하세요.
 *
 * 제약사항:
 * - 각 입력에는 정확히 하나의 답이 있다고 가정합니다.
 * - 같은 요소를 두 번 사용할 수 없습니다.
 * - 답은 어떤 순서로든 반환할 수 있습니다.
 *
 * 예시:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * 설명: nums[0] + nums[1] = 2 + 7 = 9
 *
 * Input: nums = [3, 2, 4], target = 6
 * Output: [1, 2]
 */
public class TwoSum {

    /**
     * O(n^2) 브루트포스 솔루션 - 초보자용
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        // TODO: 구현하세요
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * O(n) 해시맵 솔루션 - 최적화된 방법
     */
    public int[] twoSum(int[] nums, int target) {
        // TODO: 구현하세요
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // 정답 (참고용)
    public int[] twoSumSolution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
