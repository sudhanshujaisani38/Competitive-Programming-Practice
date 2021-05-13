class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        //find total length of List
        while(node!=null){
            node=node.next;
            len++;
        }
        //if k = len, List remains same
        if(k==len || len == 0)return head;
        k = k %len;   
        ListNode tail = head;
        for(int i =0 ; i< k;i++){
            tail = tail.next;
        }
        ListNode newHead = head;
        while(tail.next != null){
            tail = tail.next;
            newHead = newHead.next;            
        }
        tail.next = head;
        head = newHead.next;
        newHead.next = null;
        return head;
        
    }
}