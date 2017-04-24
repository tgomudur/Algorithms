package Backtrack;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * <a href = https://leetcode.com/problems/subsets/#/description>More Info</a>
 */
public class GenerateSubsets {
    public List<List<Integer>> generateSubsetsBackTrack(int[] nums) {
        return generateSubsetsBackTrackHelper(new ArrayList<>(), new ArrayList<>(), 0, nums);
    }

    public List<List<Integer>> generateSubsetsBackTrackHelper(List<List<Integer>> subsets, List<Integer> currentSubset, int start, int[] nums) {
        // Note: Create new list and then add
        subsets.add(new ArrayList<>(currentSubset));
        for (int i = start; i < nums.length; i++) {
            // Add element and recurse with new start position
            currentSubset.add(nums[i]);
            generateSubsetsBackTrackHelper(subsets, currentSubset, i + 1, nums);
            // BackTrack: Remove element added
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public List<List<Integer>> generateSubsetsBitManp(int[] nums) {
        int n = nums.length;
        long subsetSize = (long) Math.pow(2, n);
        List<List<Integer>> subsets = new ArrayList<>();

        for (long i = 0; i < subsetSize; i++) {
            List<Integer> subset = new ArrayList<>();
            long j = i;
            int bitCount = 0;

            while (j > 0) {
                if ((j & 1) == 1)
                    subset.add(nums[bitCount]);
                j = j >> 1;
                bitCount++;
            }
            subsets.add(subset);
        }

        return subsets;
    }
}
