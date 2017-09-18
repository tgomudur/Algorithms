package List.SinglyLinkedList;

/**
 * Created by tharun on 9/18/2017.
 * Description : https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapNodesInPairs {
    // Time complexity : O(n), Space complexity : O(1)
    public SinglyLinkedListNode<Integer> swapPairs(SinglyLinkedListNode<Integer> head) {
        if (head == null)
            return head;

        SinglyLinkedListNode<Integer> dummyHead = new SinglyLinkedListNode<Integer>(-1);
        dummyHead.next = head;
        SinglyLinkedListNode<Integer> prev = dummyHead, first = head, second = head.next;

        while (second != null) {
            prev.next = second;
            first.next = second.next;
            second.next = first;
            prev = first;
            first = first.next;
            second = (first == null)? null : first.next;
        }

        return dummyHead.next;
    }
}
