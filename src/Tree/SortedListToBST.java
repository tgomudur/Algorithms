package Tree;

/**
 * Created by tharun on 1/20/17.
 * Problem description: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */

import List.SinglyLinkedList.*;
import java.util.*;

public class SortedListToBST {
    // Time : O(n) Space : O(1)
    public BinarySearchTreeNode<Integer> sortedListToBST(SinglyLinkedListNode<Integer> head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    public BinarySearchTreeNode<Integer> toBST(SinglyLinkedListNode<Integer> head, SinglyLinkedListNode<Integer> tail) {
        SinglyLinkedListNode<Integer> fast = head;
        SinglyLinkedListNode<Integer> slow = head;
        if (slow == tail) return null;

        while (fast != tail && fast.getNext() != tail) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<Integer>(slow.getData());
        root.setLeft(toBST(head, slow));
        root.setRight(toBST(slow.getNext(), tail));
        return root;
    }

    // Using hashmap: Time: O(n) Space: O(n)
    public BinarySearchTreeNode<Integer> sortedListToBSTUsingMap(SinglyLinkedListNode<Integer> head) {
         if (head == null) return null;

         HashMap<Integer, SinglyLinkedListNode<Integer>> map = new HashMap<>();
         SinglyLinkedListNode<Integer> current = head;
         int i = 0;
         while (current != null) {
             map.put(i++, current);
             current = current.getNext();
         }
         return toBST(map, 0, map.size() - 1);
     }

     public BinarySearchTreeNode<Integer> toBST(HashMap<Integer, SinglyLinkedListNode<Integer>> map, int left, int right) {
         if (left > right) return null;

         int mid = (left + right)/2;
         BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<Integer>(map.get(mid).getData());
         root.setLeft(toBST(map, left, mid - 1));
         root.setRight(toBST(map, mid + 1, right));
         return root;
     }
}
