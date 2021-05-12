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
    public ListNode partition(ListNode head, int x) {
        ListNode smaller_head = new ListNode();
        ListNode greater_head = new ListNode();
        ListNode greater = greater_head;
        ListNode smaller = smaller_head;
        
        ListNode node = head;
        while(node!=null){
            if(node.val<x){
                smaller.next = node;
                smaller = smaller.next;
            }else{
                greater.next = node;
                greater=greater.next;
            }
            node = node.next;
        }
        smaller.next = greater_head.next;
        greater.next = null;
        return smaller_head.next;
    }
}