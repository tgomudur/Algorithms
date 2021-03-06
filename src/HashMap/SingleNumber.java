package HashMap;

import java.util.HashSet;

/**
 * Created by tharun on 12/26/16.
 * Problem description: https://leetcode.com/problems/single-number/
 */

class SingleNumberSolution {
    // Time complexity: O(n), Space Complexity: O(n)
    public int getSingleNumber2(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int num : nums){
            if (hs.contains(num)) hs.remove(num);
            else hs.add(num);
        }
        if (hs.size() != 0) return hs.iterator().next();
        return 0;
    }

    // XOR solution. Time complexity: O(n), Space complexity: O(1)
    public int getSingleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) result = result ^ nums[i];
        return result;
    }
}

public class SingleNumber {
    public static void main (String[] args){
        SingleNumberSolution s =  new SingleNumberSolution();
        int[] input = {2, 2, 1, 5, 1};
        System.out.println(s.getSingleNumber(input));
    }
}
