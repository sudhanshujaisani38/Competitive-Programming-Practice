/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        //adjust head to the first element where node.val != val
        while (node != null && node == head && node.val == val) {
            node = head.next;
            head = head.next;
        }
        //if  no element left, then return
        if (node == null)
            return null;
        node = node.next;
        ListNode prev = head;
        while (node != null) {
            //advance prev only when currentnode.val != val
            if (node.val != val) {
                prev.next = node;
                prev = prev.next;
            }
            node = node.next;
        }
        //handle case: when the last element.val == val, then make it null
        if (prev.next != null) {
            prev.next = null;
        }
        return head;
    }
}