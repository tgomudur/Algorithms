package List.SinglyLinkedList;

/**
 * <p>Merge Two Sorted Lists</p>
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/#/description">More Info</a>
 */
public class MergeTwoLists {
    // Iterative Approach
    public SinglyLinkedListNode mergeTwoListsIterative(SinglyLinkedListNode<Integer> l1, SinglyLinkedListNode<Integer> l2) {
         if (l1 == null) return l2;
         if (l2 == null) return l1;

         SinglyLinkedListNode mergeHead = null;
         SinglyLinkedListNode current = null;
         SinglyLinkedListNode candidate = null;
         while (l1 != null && l2 != null) {
             if (l1.data < l2.data) {
                 candidate = l1;
                 l1 = l1.next;
             } else {
                 candidate = l2;
                 l2 = l2.next;
             }
             if (mergeHead == null) {
                 mergeHead = candidate;
                 current = mergeHead;
             } else {
                 current.next = candidate;
                 current = current.next;
             }
         }

         if (l1 != null)
             current.next = l1;

         if (l2 != null)
             current.next = l2;
         return mergeHead;
    }
        // Recursive Approach
    public SinglyLinkedListNode mergeTwoLists(SinglyLinkedListNode<Integer> l1, SinglyLinkedListNode<Integer> l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        SinglyLinkedListNode mergeHead;
        if (l1.data < l2.data) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}
