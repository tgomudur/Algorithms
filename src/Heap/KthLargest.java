package Heap;

/**
 * Created by incyphae10 on 4/25/17.
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
