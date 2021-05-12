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
   
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode mid = findMid(head);
        ListNode head1=sortList(head);
        ListNode head2=sortList(mid);
        return merge(head1, head2);       
    }

    public ListNode findMid(ListNode beg){
        if(beg==null)return null;
        ListNode slow = beg;
        ListNode fast = beg;
        while(fast.next!=null && fast.next.next!=null){           
            slow = slow.next;
            fast=fast.next.next;
        }       
        ListNode mid = slow.next;
        slow.next=null; //this is really really important (breaking the chain)
        return mid;
    }
    
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode node = new ListNode();
        ListNode head=node;
        while(head1 !=null && head2 != null){
            if(head1.val<head2.val){
                node.next = head1;
                head1=head1.next;
            }else{
                node.next=head2;
                head2=head2.next;
            }
            node=node.next;
        }
        if(head1==null){
            node.next=head2;
        }else{
            node.next=head1;
        }        
        return head.next;
    }
}