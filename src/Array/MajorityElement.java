package Array;

import java.util.HashMap;

/**
 * Created by tharun on 4/4/17.
 * https://leetcode.com/problems/majority-element/#/description
 * <p>Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.</p>
 */
public class MajorityElement {
    // Moore's voting algorithm. Time : O(n) Space: O(1)
    public int majorityElement(int[] nums) {
        int count = 0, candidate = nums[0];
        int requiredTimes = (int) Math.floor(nums.length/2);

        for (int num : nums) {
            if (count == 0)
                candidate = num;
            if (num != candidate)
                count--;
            else
                count++;
        }

        // Check if candidate is indeed majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate)
                count++;
            if (count > requiredTimes)
                return candidate;
        }
        return -1;
    }

    // // Using HashMap. Time : O(n), Space: O(n/2)
     public int majorityElement2(int[] nums) {
         HashMap<Integer, Integer> map = new HashMap<>();
         int requiredTimes = (int) Math.floor(nums.length/2);
         for (int num : nums) {
             map.put(num, map.getOrDefault(num, 0) + 1);
             if (map.get(num) > requiredTimes)
                 return num;
         }
         return -1;
     }
}
