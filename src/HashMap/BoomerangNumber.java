package HashMap;

import java.util.HashMap;

/**
 * Created by tharun on 12/29/16.
 * Problem description : https://leetcode.com/problems/number-of-boomerangs/
 */
class BommerangNumberSolution {
    public int calculateDistance(int[] point1, int[] point2) {
        int dx = point1[0] - point2[0];
        int dy = point1[1] - point2[1];
        return dx*dx + dy*dy;
    }

    public int countBoomerangs(HashMap<Integer, Integer> map){
        int totalCount = 0;
        for (int value : map.values()){
            totalCount += value*(value - 1);
        }

        return totalCount;
    }

    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        int dist = 0;
        for (int i = 0; i < points.length; i++){
            for (int j = 0; j < points.length; j++){
                if (i == j) continue;

                dist = calculateDistance(points[i], points[j]);
                if (!map.containsKey(dist)) map.put(dist, 1);
                else map.put(dist, map.get(dist) + 1);
            }
            result += countBoomerangs(map);
            map.clear();
        }
        return result;
    }
}

public class BoomerangNumber {
    public static void main (String[] args) {
        BommerangNumberSolution s = new BommerangNumberSolution();
        int[][] points = {{0,0},{1,0},{2,0}};
        s.numberOfBoomerangs(points);
    }
}
