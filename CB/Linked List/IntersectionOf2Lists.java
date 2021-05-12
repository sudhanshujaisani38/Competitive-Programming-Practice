public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode h1 = headA, h2 = headB;
        //calculate length of both lists
        int len1 = 0, len2 = 0;
        while (h1 != null) {
            len1++;
            h1 = h1.next;
        }
        while (h2 != null) {
            len2++;
            h2 = h2.next;
        }
        //adjust their heads to a same level
        h1 = headA;
        h2 = headB;
        while (len1 > len2) {
            len1--;
            h1 = h1.next;
        }
        while (len2 > len1) {
            len2--;
            h2 = h2.next;
        }
        //now move one step in both the lists and check if they intersect
        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                return h1;
            } else {
                h1 = h1.next;
                h2 = h2.next;
            }
        }
        return null;
    }
}