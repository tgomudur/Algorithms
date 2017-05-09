package List.SinglyLinkedList;

/**
 * Created by incyphae10 on 5/8/17.
 */
public class RemoveNthNodeFromEnd {
    public SinglyLinkedListNode<Integer> removeNthNode(SinglyLinkedListNode<Integer> head, int n) {
        SinglyLinkedListNode<Integer> dummyHead = new SinglyLinkedListNode<Integer>(0);
        dummyHead.next = head;
        
        SinglyLinkedListNode<Integer> slow = head, fast = head, prev = dummyHead;
        int count = 1;
        while (right != null && count != n) {
            fast = fast.next;
        }g
        
        while (right.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        prev.next = slow.next;
        
        return dummyHead.next
    }
}
