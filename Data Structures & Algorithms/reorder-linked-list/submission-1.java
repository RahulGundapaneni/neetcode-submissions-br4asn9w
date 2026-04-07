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
        ListNode check = head;
        ListNode result = check;
        Stack<ListNode> st = new Stack<>();
        while(head != null) {
            st.add(head);
            head = head.next;
        }
        while (check != st.peek() && check.next != st.peek()) {
            ListNode temp = check.next;
            ListNode tail = st.pop();

            check.next = tail;
            tail.next = temp;
            check = temp;
        }
        st.pop().next = null;
        head = result;
    }
}
