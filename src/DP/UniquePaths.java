package DP;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * https://leetcode.com/problems/unique-paths/#/description
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] table = new int[m][n];

        for (int row = 0; row < m; row++) table[row][0] = 1;
        for (int col = 0; col < n; col++) table[0][col] = 1;

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                table[row][col] = table[row][col - 1] + table[row - 1][col];
            }
        }

        return table[m - 1][n - 1];
    }
}
