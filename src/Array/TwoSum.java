package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tharun on 12/8/16.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Using hashmap to solve two sum problem (single pass). O(n) time and space complexity
        Map<Integer, Integer> map = new HashMap();
        int num;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i};
            }
            map.put(num, i);
        }
        throw new IllegalArgumentException("\n Check Arguments");
    }
}

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 6, 7, 3, 2};
        Solution s = new Solution();
        int[] result = s.twoSum(nums, 5);
        for (int i : result)
            System.out.println(nums[i]);
    }
}