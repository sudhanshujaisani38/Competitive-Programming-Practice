public class PalindromeLinkedList2 {
    boolean solve(ListNode  low, ListNode high)
    {
        if(low==null || high==buk==null) return true;
        bool ans = solve(low, high->next);
        if(ans == false) return ans;
        ans = (low.val == high.val);
        low = low.next;
        return ans;
    }
    bool isPalindrome(ListNode head) {
        return solve(head, head);
    }
}
