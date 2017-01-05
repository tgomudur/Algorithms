package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> twoSumAll(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<String> pairs = new ArrayList<String>();
        int complement = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            complement = target - num;
            if (map.containsKey(complement) && map.get(complement) > 0) {
                if (num == complement && map.get(complement) < 2) continue;
                pairs.add("(" + complement + "," + num + ")");
                map.put(complement, map.get(complement) - 1);
                map.put(num, map.get(num) - 1);
            }
        }
        return pairs;
    }
}

public class TwoSum {
    public static void main(String[] args) {
//        int[] nums = {1, 4, 5, 6, 5, 5, 5, 5, 5, 5, 7, 3, 2};
        int[] nums = {1, 1, 1, 1};

        Solution s = new Solution();
        int[] result = s.twoSum(nums, 2);
        System.out.println(result);
        System.out.println(s.twoSumAll(nums, 2));

    }
}