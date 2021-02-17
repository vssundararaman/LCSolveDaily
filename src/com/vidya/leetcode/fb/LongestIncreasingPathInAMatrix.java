package com.vidya.leetcode.fb;

/**
 * 329. Longest Increasing Path in a Matrix
 * <p>
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 * <p>
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * Example 3:
 * <p>
 * Input: matrix = [[1]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 * <p>
 * Time complexity 0(M X N)
 * Space Complexity O(M X N)
 */
public class LongestIncreasingPathInAMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};

        System.out.println(longestIncreasingPath(matrix));

    }

    static int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == 0) {
                    dfs(matrix, i, j, dp, Integer.MIN_VALUE);
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result;
    }

    static int dfs(int[][] matrix, int row, int col, int[][] dp, int prev) {

        if (row <= 0 || row >= matrix.length ||
                col <= 0 || col >= matrix[0].length ||
                matrix[row][col] <= prev) {
            return 0;
        }

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int left = dfs(matrix, row, col - 1, dp, matrix[row][col]);
        int right = dfs(matrix, row, col + 1, dp, matrix[row][col]);
        int up = dfs(matrix, row - 1, col, dp, matrix[row][col]);
        int down = dfs(matrix, row + 1, col, dp, matrix[row][col]);

        dp[row][col] = Math.max(left, Math.max(right, Math.max(up, Math.max(down, up)))) + 1;

        return dp[row][col];
    }
}
