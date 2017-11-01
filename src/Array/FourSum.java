package Array;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
 * there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * https://leetcode.com/problems/4sum-ii/#/description
 */

import java.util.*;

public class FourSum {
    // Time Complexity : O(n^2)
    // Space Complexity : O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                count += map.getOrDefault(0 - (C[i] + D[j]), 0);
            }
        }
        return count;
    }
}
