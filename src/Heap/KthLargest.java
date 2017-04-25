package Heap;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * https://leetcode.com/problems/kth-largest-element-in-an-array/#/description
 */
public class KthLargest {
    public void findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else {
                if (minHeap.peek() <= num) {
                    minHeap.remove();
                    minHeap.add(num);
                }
            }
        }
        return minHeap.peek();
    }
}
