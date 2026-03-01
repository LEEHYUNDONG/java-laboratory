package com.example.java.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();

            int height = matrix.length;
            int width = matrix[0].length;
            int layers = (Math.min(height, width) + 1) / 2;

            for (int i = 0; i < layers; i++) {
                int rowStart = i;
                int rowEnd = height - 1 - i;

                int colStart = i;
                int colEnd = width - 1 - i;

                // move right
                for (int j = colStart; j <= colEnd; j++) {
                    result.add(matrix[rowStart][j]);
                }

                // move down
                for (int j = rowStart + 1; j <= rowEnd; j++) {
                    result.add(matrix[j][colEnd]);
                }

                // move left (단일 행이 아닐 때만)
                if (rowStart != rowEnd) {
                    for (int j = colEnd - 1; j >= colStart; j--) {
                        result.add(matrix[rowEnd][j]);
                    }
                }

                // move up (단일 열이 아닐 때만)
                if (colStart != colEnd) {
                    for (int j = rowEnd - 1; j > rowStart; j--) {
                        result.add(matrix[j][colStart]);
                    }
                }
            }

            return result;
        }
    }

        public static void main(String[] args) {

        Solution solution = new Solution();

        List<Integer> integers = solution.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8}, {9, 10, 11, 12}
        });

        for (Integer integer : integers) {
            System.out.print(integer);
            System.out.print(" ,");
        }
    }
}
