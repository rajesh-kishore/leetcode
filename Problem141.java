	/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        if (Objects.isNull(head) || Objects.isNull(head.next)) { // only one node
            return false;
        }

        ListNode slow = head;   
        ListNode fast = head;

        while (fast != null && fast.next != null) {
           
     
            fast = fast.next.next; // this could be fast.next.next.next as well
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        
        return false;
    }
}
