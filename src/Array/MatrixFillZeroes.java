package Array;

/**
 * Created by tharun on 5/4/17.
 */
public class MatrixFillZeroes {
    // Time : O(mn)
    // Space : O(1)
    public int fillZeroesEfficient(int[][] matrix) {
        boolean firstColumnHasZero = false;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0]) firstColumnHasZero = true
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[0].length - 1; col >= 1 ; col--) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0)
                    matrix[row][col] = 0;
            }
            if (firstColumnHasZero) matrix[row][0] = 0;
        }
    }

    // Time : O(mn)
    // Space = O(m + n)
    public int fillZeroes(int[][] matrix) {
        Set<Integer> rowsWithZeroes = new HashSet<>();
        Set<Integer> colWithZeroes = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    rowsWithZeroes.add(row);
                    colsWithZeroes.add(col);
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (rowsWithZeroes.contains(row))
                    matrix[row][col] = 0;
            }
        }

        for (int col = 0; col < matrix[0].length; col++){
            for (int row = 0; row < matrix[0].length; row++) {
                if (colsWithZeroes.contains(col))
                    matrix[row][col] = 0;
            }
        }


    }
}
