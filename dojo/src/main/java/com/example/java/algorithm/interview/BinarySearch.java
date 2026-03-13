package com.example.java.algorithm.interview;

/**
 * 문제: Binary Search
 * <p>
 * 오름차순으로 정렬된 정수 배열 nums와 정수 target이 주어집니다.
 * target이 nums에 존재하면 그 인덱스를 반환하고, 없으면 -1을 반환하세요.
 * <p>
 * O(log n) 시간 복잡도로 알고리즘을 작성해야 합니다.
 * <p>
 * 예시:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * 설명: 9는 nums에 존재하고 인덱스는 4입니다.
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * 설명: 2는 nums에 존재하지 않습니다.
 */
public class BinarySearch {

    /**
     * 반복문을 사용한 이진 탐색
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int recursiveSearch(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        return target > nums[mid] ? recursiveSearch(nums, target, mid + 1, high) : recursiveSearch(nums, target, low, mid - 1);
    }

    /**
     * 재귀를 사용한 이진 탐색
     */
    public int searchRecursive(int[] nums, int target) {
        return recursiveSearch(nums, target, 0, nums.length - 1);
    }

    // 정답 (참고용)
    public int searchSolution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 오버플로우 방지

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public int searchRecursiveSolution(int[] nums, int target) {
        return binarySearchHelper(nums, target, 0, nums.length - 1);
    }

    private int binarySearchHelper(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearchHelper(nums, target, mid + 1, right);
        } else {
            return binarySearchHelper(nums, target, left, mid - 1);
        }
    }
}
