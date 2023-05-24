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
    public ListNode reverseKGroup(ListNode head, int k) {
       return reverseKNodes(head, k);
    }


       private ListNode reverseKNodes(ListNode current, int k) {

            if (Objects.isNull(current)) {
                return current;
            }

            // reverse k
            ListNode prev = null;
            int count = 0;
            ListNode currentPrev = current;
            while (Objects.nonNull(current) && count < k) {
                ListNode currNext = current.next;
                current.next = prev;
                prev = current;
                current = currNext;
                count++;
            }

            if (count != k) { // re-reverse if k node could not be reversed
                    current = prev;
                    prev = null;
                    while (Objects.nonNull(current)) {
                        ListNode currNext = current.next;
                        current.next = prev;
                        prev = current;
                        current = currNext;
                   }
                   return prev;
            }

            currentPrev.next = reverseKNodes(current, k);

            return prev;

    }





}
