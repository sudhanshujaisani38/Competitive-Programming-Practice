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
    public ListNode merge2List(ListNode head1, ListNode head2){
        ListNode node = new ListNode();
        ListNode head = node;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                node.next = head1;
                head1 = head1.next;
            }else{
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        while(head1 != null){
            node.next = head1;
            head1 = head1.next;
            node=node.next;
        }
        while(head2 != null){
            node.next = head2;
            head2 = head2.next;
            node=node.next;
        }
        return head.next;
        
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = null;
        int k  = lists.length;
        for(int i=0;i<k;i++){
            node = merge2List(node,lists[i]);
        }
        return node;        
    }
}