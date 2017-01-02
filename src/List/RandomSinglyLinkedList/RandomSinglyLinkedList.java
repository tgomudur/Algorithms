package List.RandomSinglyLinkedList;

import java.util.HashMap;
/**
 * Created by tharun on 1/1/17.
 */

public class RandomSinglyLinkedList {
    RandomSinglyLinkedListNode head;

    // O(n) time complexity and O(1) space complexity
    public RandomSinglyLinkedListNode copyRandomList(RandomSinglyLinkedListNode head) {
        if (head == null) return head;

        RandomSinglyLinkedListNode curr = head, l1, l2, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next =  new RandomSinglyLinkedListNode(curr.label);
            curr.next.next = temp;
            curr = curr.next.next;
        }

        l1 = head; l2 = head.next;
        while (l1 != null) {
            if (l1.random != null) l2.random = l1.random.next;
            l1 = l1.next.next;
            if (l2.next != null) l2 = l2.next.next;
        }

        RandomSinglyLinkedListNode newListHead = new RandomSinglyLinkedListNode(0);
        l1 = head; l2 = head.next;
        curr = newListHead;
        while (l1 != null) {
            l1.next = l2.next;
            curr.next = l2;
            curr = curr.next;
            l1 = l1.next;
            if (l2.next != null) l2 = l2.next.next;
        }

        return newListHead.next;
    }
    
    // O(n) space complexity (slightly more space effficient than copyRandomList1) as it uses one hashmap instead of two.
    // O(n) time complexity
    public RandomSinglyLinkedListNode copyRandomList2(RandomSinglyLinkedListNode head) {
        RandomSinglyLinkedListNode newHead = null, newListNode = null;
        RandomSinglyLinkedListNode current = head;
        HashMap<RandomSinglyLinkedListNode, RandomSinglyLinkedListNode> map = new HashMap<>();
        while (current != null) {
            map.put(current, new RandomSinglyLinkedListNode(current.label));
            current = current.next;
        }
        current = head;
        while (current != null) {
            newListNode = map.get(current);
            newListNode.next = map.get(current.next);
            newListNode.random = map.get(current.random);

            if (newHead == null) newHead = newListNode;
            current = current.next;
        }
        return newHead;
    }

    // O(n) space complexity and O(n) time complexity
    public RandomSinglyLinkedListNode copyRandomList1(RandomSinglyLinkedListNode head) {
        RandomSinglyLinkedListNode newHead = null, prev = null;
        RandomSinglyLinkedListNode current = head;
        HashMap<Integer, Integer> parentChildMap = new HashMap<Integer, Integer>();
        HashMap<Integer, RandomSinglyLinkedListNode> labelReferenceMap = new HashMap<Integer, RandomSinglyLinkedListNode>();
        while (current != null) {
            if (prev == null) {
                newHead = new RandomSinglyLinkedListNode(current.label);
                prev = newHead;
            } else {
                prev.next = new RandomSinglyLinkedListNode(current.label);
                prev = prev.next;
            }
            if (current.random != null) parentChildMap.put(current.label, current.random.label);
            else parentChildMap.put(current.label, null);
            labelReferenceMap.put(current.label, prev);
            current = current.next;
        }

        current = newHead;
        while (current != null) {
            current.random = labelReferenceMap.get(parentChildMap.get(current.label));
            current = current.next;
        }
        return newHead;
    }
    
}
