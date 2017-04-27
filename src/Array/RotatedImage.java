package Array;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * <a href=https://leetcode.com/problems/rotate-image/#/description>More Info</a>
 */
public class RotatedImage {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int tmp;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
                left++;
                right--;
            }
        }
    }
}
