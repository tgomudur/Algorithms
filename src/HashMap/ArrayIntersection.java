package HashMap;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

/**
 * Created by tharun on 12/21/16.
 * Problem description: https://leetcode.com/problems/intersection-of-two-arrays/
 */

class ArrayIntersectionSolution {
    public int[] toInt(Set<Integer> set) {
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer val : set) result[i++] = val;
        return result;
    }

    public int[] findIntersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> resultSet = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++){
            if (!map.containsKey(nums1[i]))
                map.put(nums1[i], i);
        }

        for (int i = 0; i < nums2.length; i++){
            if (map.containsKey(nums2[i])) resultSet.add(nums2[i]);
        }

        return toInt(resultSet);
    }
}


public class ArrayIntersection {
    public static void main(String[] args){
        ArrayIntersectionSolution s = new ArrayIntersectionSolution();
        int[] nums1 = {1, 2, 3, 5, 8, 9};
        int[] nums2 = {4, 5, 6, 7, 8, 9};

        System.out.println("Intersecting elements are : ");
        System.out.print(Arrays.toString(s.findIntersection(nums1, nums2)));
    }
}
