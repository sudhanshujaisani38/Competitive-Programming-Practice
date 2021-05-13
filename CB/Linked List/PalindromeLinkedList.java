class Solution {
    public ListNode reverse(ListNode head) {
        ListNode node = head, prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }       
        if (fast != null) {
            //if there are odd no of nodes, add additonal node in the middle to make it even
            ListNode node = new ListNode(slow.val);
            node.next = slow.next;
            slow.next = node;
            slow = slow.next;
        }
        ListNode head2 = reverse(slow);
        ListNode head1 = head;
        while (head2 != null) {
            if (head1.val != head2.val)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
}