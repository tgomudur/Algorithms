package HashMap;

/**
 * Created by tharun on 1/10/17.
 * Problem description: https://leetcode.com/problems/h-index/
 */
import java.util.*;

class HIndexSolution {
    // Binary Search Solution to HIndex.
    // Time Complexity: O(n), Space Complexity : O(1)
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;

        Arrays.sort(citations);
        int left = 0, right = n - 1;
        int mid;
        while (left <= right) {
            mid = (left + right)/2;
            if (citations[mid] == n - mid) return citations[mid];
            else if (citations[mid] < n - mid) left = mid + 1;
            else right = mid - 1;
        }
        return n - right - 1;
    }
}

public class HIndex {
}
