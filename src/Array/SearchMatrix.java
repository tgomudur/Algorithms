package Array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * https://leetcode.com/problems/search-a-2d-matrix-ii/#/description
 */
public class SearchMatrix {
    // Time : O(m + n)
    // Space : O(1)
    public boolean search(int[][] matrix, int target) {
        if (matrix != null && matrix.length != 0 && matrix[0].length != 0) {
            int m = matrix.length, n = matrix[0].length;
            int row = m - 1, col = 0;

            while (row >= 0 && col <= n - 1) {
                if (matrix[row][col] > target)
                    row--;
                else if (matrix[row][col] < target)
                    col++;
                else
                    return true;
            }
        }
        return false;
    }
}
