package List.SinglyLinkedList;

/**
 * Created by tharun on 9/20/2017.
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class ReverseKGroupsList {
    // Reverses a part of the list provided the head and tail. Reverses all node before the tail.
    // Time complexity : O(n)
    // Space complexity : O(1)
    private SinglyLinkedListNode<Integer> reverseList(SinglyLinkedListNode<Integer> head, SinglyLinkedListNode<Integer> tail) {
        SinglyLinkedListNode<Integer> dummyHead = new SinglyLinkedListNode<Integer>(-1);
        dummyHead.next = head;

        SinglyLinkedListNode<Integer> prev, current, next;
        prev = head;
        current = prev.next;

        while (current != tail) {
            next = current.next;
            prev.next = next;
            current.next = dummyHead.next;
            dummyHead.next = current;

            current = next;
        }

        return dummyHead.next;
    }

    // Reverses k groups of the list.
    // Time : O(n)
    // Space : O(1)
    public SinglyLinkedListNode<Integer> reverseListKGroup(SinglyLinkedListNode<Integer> head, int k) {
        SinglyLinkedListNode<Integer> dummyHead = new SinglyLinkedListNode<Integer>(-1);
        dummyHead.next = head;

        SinglyLinkedListNode<Integer> insertNode = dummyHead;
        SinglyLinkedListNode<Integer> currentGroupHead = head, nextGroupHead;
        int count;

        while (currentGroupHead != null) {
            count = 0;
            nextGroupHead = currentGroupHead;
            while (count < k && nextGroupHead != null) {
                nextGroupHead = nextGroupHead.next;
                count++;
            }

            if (count != k)
                break;

            insertNode.next = reverseList(currentGroupHead, nextGroupHead);
            insertNode = currentGroupHead;
            currentGroupHead = nextGroupHead;
        }
        return dummyHead.next;
    }

}
