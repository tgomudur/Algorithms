package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tharun on 9/19/2017.
 * https://leetcode.com/problems/spiral-matrix/description/
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length != 0 && matrix[0].length != 0) {
            int rowBegin = 0, colBegin = 0;
            int rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;

            while (rowBegin <= rowEnd && colBegin <= colEnd) {
                // Traverse right
                for (int i = colBegin; i <= colEnd; i++)
                    result.add(matrix[rowBegin][i]);
                rowBegin++;

                // Traverse down
                for (int i = rowBegin; i <= rowEnd; i++)
                    result.add(matrix[i][colEnd]);
                colEnd--;

                // Traverse left
                if (rowEnd >= rowBegin) {
                    for (int i = colEnd; i >= colBegin; i--)
                        result.add(matrix[rowEnd][i]);
                }
                rowEnd--;

                // Traverse up
                if (colEnd >= colBegin) {
                    for (int i = rowEnd; i >= rowBegin; i--)
                        result.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }

        return result;
    }
}
