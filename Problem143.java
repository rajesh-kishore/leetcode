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
    public void reorderList(ListNode head) {

        if (head.next == null) {
            return; // when only one node then no point of proceeding further
        }


        // find the middle
        ListNode fast = head;
        ListNode slow = head;

        ListNode firsListLast = null;

        while (fast != null && fast.next != null) {
            firsListLast = slow;
              slow = slow.next;
              fast = fast.next.next;  
        }

        // segeregate the list
        firsListLast.next = null; // terminate the firstList last's node's next

        // now slow is starting point of splitted list
        // we will reverse this
        ListNode nextListStartBeforeReverse = slow;

        ListNode prev = null;
        while (slow != null) {
            ListNode currNext = slow.next;
            slow.next = prev;
            prev = slow;
            slow = currNext;
        }

        // now prev is reversed head of second list
        ListNode secondListCurrent = prev;

       
        ListNode firstListCurrent = head;

        while (firstListCurrent != null) { // incase of odd nodes - first list will be smaller
            ListNode firstListNext = firstListCurrent.next;
            firstListCurrent.next = secondListCurrent;
            ListNode secondListCurrentNext = secondListCurrent.next;
            if (secondListCurrent.next != null && firstListNext == null) { 
                    // do nothing
            } else {
                            secondListCurrent.next = firstListNext; // link second list node to first list only when there is some left over in first

            }
            firstListCurrent = firstListNext;
            secondListCurrent = secondListCurrentNext;
        }        

    }
}
