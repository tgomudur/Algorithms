package Heap;

import List.SinglyLinkedList.SinglyLinkedListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by tharun on 9/20/2017.
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class MergeKSortedLists {
    // Time complexity : O(kn), where k is the number of lists and n is the max number of elements in a list
    // Space complexity : O(kn), O(k) for the min heap and O(kn) for the result
    public SinglyLinkedListNode<Integer> mergeKLists(SinglyLinkedListNode<Integer>[] lists) {
        SinglyLinkedListNode<Integer> dummyHead = new SinglyLinkedListNode<Integer>(1);
        SinglyLinkedListNode<Integer> tailNode = dummyHead;

        PriorityQueue<SinglyLinkedListNode<Integer>> minHeap = new PriorityQueue<>(new Comparator<SinglyLinkedListNode<Integer>>() {
            @Override
            public int compare(SinglyLinkedListNode<Integer> o1, SinglyLinkedListNode<Integer> o2) {
                return o1.getData() - o2.getData();
            }
        });

        for (SinglyLinkedListNode<Integer> head : lists) {
            if (head != null)
                minHeap.add(head);
        }

        while (!minHeap.isEmpty()) {
            tailNode.setNext(minHeap.remove());
            tailNode.setNext(tailNode.getNext());
            if (tailNode.getNext() != null)
                minHeap.add(tailNode.getNext());
        }

        return dummyHead.getNext();
    }

    // Without using extra datastructure like a heap. Time limit exceeds.
    /*
    public boolean hasAllReachedEnd(ListNode[] listCurrent) {
         for (int i = 0; i < listCurrent.length; i++) {
             if (listCurrent[i] != null)
                 return false;
         }
         return true;
     }

     // Time complexity : O(kn)
     public ListNode mergeKLists(ListNode[] lists) {
         ListNode resultHead = new ListNode(-1);
         ListNode resultCurrent = resultHead;
         int n = lists.length;
         ListNode[] listCurrent = new ListNode[n];
         ListNode nextNode;

         for (int i = 0; i < n; i++)
             listCurrent[i] = lists[i];

         while (!hasAllReachedEnd(listCurrent)) {
             nextNode = null;
             for (int i = 0; i < n; i++) {
                 if (listCurrent[i] != null) {
                     if(nextNode == null)
                         nextNode = listCurrent[i];

                     if (listCurrent[i].val < nextNode.val) {
                         nextNode = listCurrent[i];
                     }
                 }
             }

             for (int i = 0; i < n; i++) {
                 if (listCurrent[i] == nextNode) {
                     listCurrent[i] = listCurrent[i].next;
                     break;
                 }
             }

             resultCurrent.next = nextNode;
             resultCurrent = resultCurrent.next;
         }

         return resultHead.next;
     }
     */
}
