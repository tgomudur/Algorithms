package List.SinglyLinkedList;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * https://leetcode.com/problems/intersection-of-two-linked-lists/#/solutions
 */
public class ListIntersection {
    public SinglyLinkedListNode<Integer> findIntersection(SinglyLinkedListNode<Integer> headA, SinglyLinkedListNode<Integer> headB) {
        if (headA == null || headB == null) return null;
        SinglyLinkedListNode<Integer> currentA = headA;
        SinglyLinkedListNode<Integer> currentB = headB;
        while (currentA != currentB) {
            currentA = (currentA == null)? headB : currentA.next;
            currentB = (currentB == null)? headA : currentB.next;
        }
        return currentA;
    }
}
