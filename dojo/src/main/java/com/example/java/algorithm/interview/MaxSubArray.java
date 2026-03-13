package com.example.java.algorithm.interview;

/**
 * 문제: Maximum Subarray (Kadane's Algorithm)
 *
 * 정수 배열 nums가 주어질 때, 가장 큰 합을 가진 연속된 부분 배열을 찾아 그 합을 반환하세요.
 *
 * 예시:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * 설명: [4,-1,2,1]의 합이 6으로 가장 큽니다.
 *
 * Input: nums = [1]
 * Output: 1
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * 설명: [5,4,-1,7,8]의 합이 23입니다.
 */
public class MaxSubArray {

    /**
     * O(n^2) 브루트포스 솔루션
     */
    public int maxSubArrayBruteForce(int[] nums) {

        return 0;
    }

    /**
     * O(n) Kadane's Algorithm - 동적 프로그래밍
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums is null or empty");
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 현재까지의 합에 다음 요소를 더할지, 아니면 새로 시작할지 결정
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // 정답 (참고용)
    public int maxSubArraySolution(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 현재까지의 합에 다음 요소를 더할지, 아니면 새로 시작할지 결정
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
