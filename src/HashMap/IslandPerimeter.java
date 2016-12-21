package HashMap;

/**
 * Created by tharun on 12/20/16.
 * Problem Description: https://leetcode.com/problems/island-perimeter/
 */

class IslandPerimeterSolution {
    public int findIslandPerimeter(int[][] grid) {
        int[] countArr = new int[2];
        int connectedEdges = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                // Count islands and waters
                countArr[grid[i][j]] += 1;
                // If island, count connected edges
                if (grid[i][j] == 1){
                    // Count top connectedEdges
                    if (i != 0 && grid[i-1][j] == 1) connectedEdges++;
                    // Count right connectedEdges
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) connectedEdges++;
                }
            }
        }
        // Formula Explanation: Sides of all 1's - Common sides*2.
        return countArr[1]*4 - (connectedEdges)*2;
    }
}
public class IslandPerimeter {
    public static void main (String[] args){
        IslandPerimeterSolution s = new IslandPerimeterSolution();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.print("Perimeter : " + s.findIslandPerimeter(grid));
    }
}
