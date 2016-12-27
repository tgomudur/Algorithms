package HashMap;

/**
 * Created by tharun on 12/26/16.
 * Problem description: https://leetcode.com/problems/single-number/
 */

public class SingleNumberSolution {
    // Time complexity: O(n), Space Complexity: O(n)
    public int singleNumber2(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int num : nums){
            if (hs.contains(num)) hs.remove(num);
            else hs.add(num);
        }
        if (hs.size() != 0) return hs.iterator().next();
        return 0;
    }

    // XOR solution. Time complexity: O(n), Space complexity: O(1)
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) result = result ^ num;
        return result;
    }
}

public class SingleNumber {
    
}
