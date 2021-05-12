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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode head1 = head;       
        ListNode firstOf2 = head.next;
        ListNode head2 = head.next;
        ListNode node = head2.next;      
        int count=0;
        while(node != null){
            if((count&1)==0){
                head1.next = node;
                head1 = head1.next;
            }else{
                head2.next = node;
                head2=head2.next;
            }
            node=node.next;
            count++;
        }
        head2.next = null;
        head1.next = firstOf2;
        return head;
    }
}