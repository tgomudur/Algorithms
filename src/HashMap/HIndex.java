package HashMap;

/**
 * Created by tharun on 1/10/17.
 * Problem description: https://leetcode.com/problems/h-index/
 */
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class HIndexSolution {
    // Binary Search Solution to HIndex.
    // Time Complexity: O(nlogn), Space Complexity : O(1)
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

    // Using bucket sort
    // Time Complexity: O(n), Space Complexity: O(n)
    public int hIndexFast(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;

        int[] count = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (citations[i] > n) count[n]++;
            else count[citations[i]]++;
        }

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) return i;
        }

        return sum;
    }
}

public class HIndex {
    @Test
    public void testhIndex() {
        HIndexSolution s = new HIndexSolution();
        assertEquals(1, s.hIndex(new int[]{100}));
        assertEquals(3, s.hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    @Test
    public void testhIndexFast() {
        HIndexSolution s = new HIndexSolution();
        assertEquals(1, s.hIndexFast(new int[]{100}));
        assertEquals(3, s.hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
