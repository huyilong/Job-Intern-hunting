//Find the node where the cycle begins

//sol: fast/slow runner 


public class LinkedListCycle2{
	public ListNode detectCycle(ListNode head){
		if(head==null || head.next==null){
			return true;
		}
		ListNode fast = head;
		ListNode slow = head;
        //moving runners
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				break;
			}
		}
		if(fast==null || fast.next==null){
			return null;
		}else{
			//move one runner to head, after same steps, we will reach the loop head
			fast = head;
			while(fast != slow){
				fast = fast.next;
				slow = slow.next;
			}
			return fast;
		}
	}
}