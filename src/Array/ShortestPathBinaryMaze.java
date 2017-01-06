package Array;

import Heap.Point;
import java.util.*;
/**
 * Created by tharun on 1/5/17.
 */
class ShortestPathBinaryMazeSolution {
    public boolean isValidIndex(int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >=n) return false;
        return true;
    }

    public int shortestPath(int[][] maze, Point source, Point dest) {
        if (maze[source.x][source.y] == 0 && maze[dest.x][dest.y] == 0) return -1;

        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int pathSum = 0;

        Point current;
        int currentDist = 0;
        Queue<Point> q = new ArrayDeque<>();
        q.add(source);
//        visited[source.x][source.y] = true;
//        pathSum += maze[source.x][source.y];
        while (!q.isEmpty()) {
            current =  q.poll();
            currentDist = current.dist;
            if (current.x == dest.x && current.y == dest.y) return currentDist;

            if (isValidIndex(current.x, current.y, m, n) && maze[current.x][current.y] > 0 && !visited[current.x][current.y]) {
                visited[current.x][current.y] = true;
                currentDist += maze[current.x][current.y];
                q.add(new Point(current.x + 1, current.y, currentDist));
                q.add(new Point(current.x-1, current.y, currentDist));
                q.add(new Point(current.x, current.y+1, currentDist));
                q.add(new Point(current.x, current.y-1, currentDist));
            }
        }
        return currentDist;
    }
}

public class ShortestPathBinaryMaze {
    public static void main(String[] args) {
        int[][] maze = {
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };
        Point source = new Point(0 , 0);
        Point destination = new Point(3, 4);
        ShortestPathBinaryMazeSolution s = new ShortestPathBinaryMazeSolution();
        System.out.println(s.shortestPath(maze, source, destination));

    }
}
