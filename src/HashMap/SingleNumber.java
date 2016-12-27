package HashMap;

/**
 * Created by tharun on 12/26/16.
 */

public class SingleNumberSolution {
    // Time complexity: O(n), Space Complexity: O(n)
    public int singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int num : nums){
            if (hs.contains(num)) hs.remove(num);
            else hs.add(num);
        }
        if (hs.size() != 0) return hs.iterator().next();
        return 0;
    }
}

public class SingleNumber {
}
