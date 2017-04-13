package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/#/description
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (numRows > 0) resultList.add(Arrays.asList(1));
        if (numRows > 1) resultList.add(Arrays.asList(1, 1));

        List<Integer> currentRow = new ArrayList<>();
        List<Integer> prevRow;
        for (int i = 2; i < numRows; i++) {
            currentRow = new ArrayList<>();
            currentRow.add(1);
            prevRow = resultList.get(resultList.size() - 1);
            for (int j = 0; j < prevRow.size() - 1; j++) {
                currentRow.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            currentRow.add(1);
            resultList.add(currentRow);
            System.out.println(currentRow);
        }
        return resultList;
    }
}
