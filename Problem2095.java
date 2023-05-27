/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
            if (head.next ==  null) { // only one node
                return null;
            }

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // slow is now at the middle element
            // we have to get to the node before middle

            ListNode start = head;
            while (start.next != slow) {
                start = start.next;
            }

            // now start is just before middle element
            start.next = slow.next;


            return head;

    }
}
