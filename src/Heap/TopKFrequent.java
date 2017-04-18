package Heap;

/**
 * Created by tharun on 1/9/17.
 * Problem description: https://leetcode.com/problems/top-k-frequent-elements/
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class EntryComparator implements Comparator<Map.Entry<Integer, Integer>> {
    @Override
    public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
        return entry1.getValue() - entry2.getValue();
    }
}

class TopKFrequentSolution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        EntryComparator cmp = new EntryComparator();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, cmp);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(entry);
            } else {
                if (minHeap.peek().getValue() < entry.getValue()) {
                    minHeap.poll();
                    minHeap.add(entry);
                }
            }
        }

        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < k; i++) {
            result.add(0, minHeap.poll().getKey());
        }

        return result;
    }

    // Bucket sort approach: Time: O(n). Space: O(n)
    public List<Integer> topKFrequent2(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        int frequency;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            frequency = entry.getValue();
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();
        for(int i = bucket.length - 1; i >=0 && result.size() < k; i--) {
            if (bucket[i] != null)
                result.addAll(bucket[i]);
        }

        return result;
    }
}

public class TopKFrequent {
    @Test
    public void testTopKFrequent() {
        int[] nums = {1,1,1,2,2,3};
        TopKFrequentSolution s = new TopKFrequentSolution();
        List<Integer> actual =  Arrays.asList(1,2);
        assertEquals(actual, s.topKFrequent(nums, 2));
    }
}
