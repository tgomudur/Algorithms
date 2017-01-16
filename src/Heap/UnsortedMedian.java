package Heap;

/**
 * Created by tharun on 1/15/17.
 * Find median of an unsorted array range
 */
import java.util.PriorityQueue;
import java.util.Collections;
import org.junit.Test;
import static org.junit.Assert.*;

class UnsortedMedianSolution {
    public void addNumInHeap(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int num) {
        if (maxHeap.size() == minHeap.size()) {
            if (maxHeap.size() != 0 && maxHeap.peek() > num) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        } else {
           if (minHeap.peek() < num) {
               maxHeap.offer(minHeap.poll());
               minHeap.offer(num);
           } else {
               maxHeap.offer(num);
           }
        }

    }

    public double findMedian(int[] nums, int start,int end) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(end - start, Collections.reverseOrder());
        for(int i = start; i < end; i++) {
            addNumInHeap(maxHeap, minHeap, nums[i]);
        }
        return (minHeap.size() == maxHeap.size())? (double) (minHeap.peek() + maxHeap.peek())/2 : minHeap.peek();
    }
}
public class UnsortedMedian {
    @Test
    public void testFindMedian() {
        int[] nums = {3, 7, 5, 2, 1, 0, 4, 10};
        UnsortedMedianSolution s = new UnsortedMedianSolution();
        assertEquals(3.5, s.findMedian(nums, 0, nums.length), 0.00001);
    }
}
