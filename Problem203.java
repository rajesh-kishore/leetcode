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
    public ListNode removeElements(ListNode head, int val) {

        if (Objects.isNull(head)) {
            return head;
        }

        ListNode tempHead = head;

        while (Objects.nonNull(tempHead) && tempHead.val == val) {
            tempHead = tempHead.next; // keep ignoring such head;
        }

        if (Objects.isNull(tempHead)) {
            return tempHead; // all first nodes turned out to be val only
        }

        head = tempHead; // // the first non null val is captured

        ListNode prev = tempHead;
        tempHead = tempHead.next;
        while (Objects.nonNull(tempHead)) {
                if (tempHead.val == val) {
                    prev.next = tempHead.next;
                } else {
                    prev = tempHead;
                }
                tempHead = tempHead.next;

        }
        prev.next =  tempHead; 

        return head; // return the first non null val
    }
}
