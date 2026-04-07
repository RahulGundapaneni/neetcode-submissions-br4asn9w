class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            st.push(curr);
            curr = curr.next;
        }

        ListNode reverseHead = st.pop();
        curr = reverseHead;

        while (!st.isEmpty()) {
            curr.next = st.pop();
            curr = curr.next;
        }

        curr.next = null;
        return reverseHead;
    }
}
