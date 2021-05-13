class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        if(head==null)return head;
        for(int  i =0 ;i<n;i++){
            node = node.next;
        }
        //if node == null, that means head is needed to be removed.
        if(node==null){
            head = head.next;
            return head;
        }
        ListNode node2 = head;
        while(node !=null && node.next!=null){
            node = node.next;
            node2=node2.next;
        }
        node2.next = node2.next.next;
        return head;
    }
}