//remove n-th node from the end of list

//sol: two runners, initially one is n steps ahead

public class RemoveNthNode{
	public ListNode removeNthFromEnd(ListNode head, int n){
		if(head==null || n<=0){
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		//move p2 n steps forward
		while(n > 0 && p2!=null){
			p2 = p2.next;
			n --;
		}

		//n larger than length of list
        if(n > 0){
        	return head;
        //node to remove is the head
        }else if(p2 == null){
			return head.next;
		//find n-th last node and then remove 
		}else{
			while(p2.next != null){
				p2 = p2.next;
				p1 = p1.next;
			}
			p1.next = p1.next.next;
			return head;
		}
	}
}