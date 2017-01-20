package Tree;

/**
 * Created by tharun on 1/20/17.
 * Problem description: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */

public class SortedListToBST {
    // Time : O(n) Space : O(1)
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    public TreeNode toBST(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;
        if (slow == tail) return null;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return root;
    }

    // Using hashmap: Time: O(n) Space: O(n)
    public TreeNode sortedListToBSTUsingMap(ListNode head) {
         if (head == null) return null;

         HashMap<Integer, ListNode> map = new HashMap<>();
         ListNode current = head;
         int i = 0;
         while (current != null) {
             map.put(i++, current);
             current = current.next;
         }
         return toBST(map, 0, map.size() - 1);
     }

     public TreeNode toBST(HashMap<Integer, ListNode> map, int left, int right) {
         if (left > right) return null;

         int mid = (left + right)/2;
         TreeNode root = new TreeNode(map.get(mid).val);
         root.left = toBST(map, left, mid - 1);
         root.right = toBST(map, mid + 1, right);
         return root;
     }
}
