package Heap;

import java.util.*;
/**
 * Created by tharun on 1/3/17.
 */

class MaxHeapTest {
    public void getKSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());

        for (int item : arr) {
            if (maxHeap.size() < k) maxHeap.offer(item);
            else {
                if (maxHeap.peek() > item){
                    maxHeap.poll();
                    maxHeap.offer(item);
                }
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.println(maxHeap.poll());
        }
    }
}

public class MaxHeap {
    public static void main (String[] args) {
        MaxHeapTest s = new MaxHeapTest();
        int[] arr = {5, 2, 8, 4, 5, 3, 1, 0, 9};
        s.getKSmallest(arr, 5);
    }
}