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
    public ListNode swapPairs(ListNode head) {
       // 1-2-3
       return swapNode(head);
    }

    private ListNode swapNode(ListNode before) {

            if (Objects.isNull(before) || Objects.isNull(before.next)) {
                return before;
            }
            
            ListNode next = before.next;

            ListNode nextNext = next.next;
       
            next.next = before;
            before.next = swapNode(nextNext);

            return next;
    }
}
