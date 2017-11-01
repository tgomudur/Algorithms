package List.SinglyLinkedList;

public class RemoveNthNodeFromEnd {
    public SinglyLinkedListNode<Integer> removeNthNode(SinglyLinkedListNode<Integer> head, int n) {
        SinglyLinkedListNode<Integer> dummyHead = new SinglyLinkedListNode<Integer>(0);
        dummyHead.next = head;
        
        SinglyLinkedListNode<Integer> slow = head, fast = head, prev = dummyHead;
        int count = 1;
        while (slow != null && count != n) {
            fast = fast.next;
        }
        
        while (slow.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        prev.next = slow.next;
        
        return dummyHead.next;
    }
}
