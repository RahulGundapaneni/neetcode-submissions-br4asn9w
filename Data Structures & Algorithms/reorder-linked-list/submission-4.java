class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Find the end of the first half
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Split the list and reverse the second half
        ListNode curr = slow.next;
        slow.next = null;          // cut first half off
        ListNode secHalf = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = secHalf;
            secHalf = curr;
            curr = next;
        }

        // 3. Merge the two halves alternately
        ListNode first = head;
        while (secHalf != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = secHalf.next;

            first.next = secHalf;
            secHalf.next = firstNext;

            first = firstNext;
            secHalf = secondNext;
        }
    }
}