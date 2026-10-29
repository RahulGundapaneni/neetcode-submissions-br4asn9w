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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode count = head;
        while(count != null) {
            count = count.next;
            length++;
        }
        int removeIndex = length - n;
        if (removeIndex == 0) {
            return head.next;      // removing the head
        }
        ListNode iterator = head;
        for (int i = 0; i < removeIndex - 1; i++) {
            iterator = iterator.next;
        }
        iterator.next = iterator.next.next;

        return head;
    }
}
