package com.example.java.algorithm.leetcode;

public class NextPermutation {
    static class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2;

            // Step 1: 뒤에서부터 nums[i] < nums[i+1]인 i 찾기
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }

            // Step 2: i를 찾았다면 교환할 j 찾기
            if (i >= 0) {
                int j = n - 1;

                while (nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }

            // Step 3: i+1부터 끝까지 뒤집기
            reverse(nums, i + 1, n - 1);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                swap(nums, start++, end--);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
    }
}
