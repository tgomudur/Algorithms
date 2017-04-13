package List.SinglyLinkedList;

/**
 * Palindrome Linked List
 * <a href="https://leetcode.com/problems/palindrome-linked-list/#/solutions">More Info</a>
 */
public class PalindromeList {
    // Time Complexity : O(n). Space Complexity: O(1)
    public boolean isPalindrome(SinglyLinkedListNode<Integer> head) {
        // In this approach, the list is modified and not restored. Could be restored though without increasing complexity.
        SinglyLinkedListNode<Integer> current1 = head;
        SinglyLinkedListNode<Integer> slow = head;
        SinglyLinkedListNode<Integer> fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        SinglyLinkedListNode<Integer> current2 = reverseListFrom(slow);
        while (current1 != slow && current2 != null) {
            if (current1.data != current2.data)
                return false;
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

    public SinglyLinkedListNode<Integer> reverseListFrom(SinglyLinkedListNode<Integer> start) {
        SinglyLinkedListNode<Integer> current = start;
        SinglyLinkedListNode<Integer> prev = null, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

