//Medallia

//Reverse nodes in k group

public class ReverseKGroup{
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode left = dummy;
        ListNode iter = head;
        int count = 0;
        
        while(iter != null){
            count ++;
            ListNode right = iter.next;
            if(count == k){
                left = reverseGroup(left, right);
                count = 0;
            }
            iter = right;
        }
        return dummy.next;
    }
    
    public ListNode reverseGroup(ListNode left, ListNode right){
        ListNode prev = left.next;
        ListNode curr = left.next.next;
        ListNode tail = left.next;
        
        while(curr != right){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        left.next = prev;
        tail.next = curr;
        return tail;
    }
}
