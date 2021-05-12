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
        int k  = lists.length;
        if(k==0)return null;
        for(int gap=1;gap<=k;gap*=2)
        {
            for(int i=0;i+gap<k;i+=(2*gap)){
                lists[i] = merge2List(lists[i],lists[i+gap]);
            }
        }        
        return lists[0];        
    }
}