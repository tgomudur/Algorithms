package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tharun on 8/2/2017.
 * https://leetcode.com/problems/combination-sum-ii/description/
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * **Note**
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 */
public class CombinationSum {
    // Recursive solution: DFS
    public List<List<Integer>> findCombinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        findCombinationSumHelper(candidates, results, new ArrayList<>(), 0, target);
        return results;
    }

    private void findCombinationSumHelper(int[] candidates, List<List<Integer>> results, List<Integer> result, int startIdx, int target) {
        if (target < 0)
            return;

        if (target == 0) {
            results.add(result);
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            // Skip duplicate solutions
            if (i > startIdx && candidates[i] == candidates[i - 1])
                continue;

            result.add(candidates[i]);
            findCombinationSumHelper(candidates, results, result, i + 1, target - candidates[i]);
            result.remove(result.size() - 1);
        }
    }
}
