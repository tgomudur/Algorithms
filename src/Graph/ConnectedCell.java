package Graph;

/**
 * <h2>Connected Cell</h2>
 * <a href = 'https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid'>More Info</</a>
 */
public class ConnectedCell {
    // Time Complexity: O(nm). Space Complexity : O(n) [n levels of call stack]
    public int getBiggestRegion(int[][] matrix) {
        int maxRegionSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    maxRegionSize = Math.max(maxRegionSize, dfs(matrix, i, j));
                }
            }
        }
        return maxRegionSize;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != 1)
            return 0;

        int count = 0;
        matrix[i][j] = 0;
        count += 1;

        count += dfs(matrix, i - 1, j - 1);
        count += dfs(matrix, i - 1, j);
        count += dfs(matrix, i - 1, j + 1);
        count += dfs(matrix, i, j - 1);
        count += dfs(matrix, i, j + 1);
        count += dfs(matrix, i + 1, j - 1);
        count += dfs(matrix, i + 1, j);
        count += dfs(matrix, i + 1, j + 1);


        return count;
    }
}
