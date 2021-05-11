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
    public ListNode reverse(ListNode head){
        ListNode node = head;
        ListNode prev = null;
        while(node != null){
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        
        
        ListNode slow = head, fast = head;
        //find mid of the linked list
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //if the no of nodes is odd, head2 will be next of slow e.g for 1,2,3,4,5 head2 should be 4
        //if the no of nodes is even, head2 will be slow itself e.g for 1,2,3,4 head2 should be head2 should be 3
        if(fast != null){
            slow = slow.next;
        }
        //reverse the  second half of linked list
        ListNode head2 = reverse(slow);
        ListNode head1 = head;
       
        while(head2 != null){
            ListNode temp = head1.next;
            head1.next = head2;
            ListNode temp2 = head2.next;
            head2.next = temp;
            head1 = temp;
            head2 = temp2;
        }
        head1.next = null;
    }
}