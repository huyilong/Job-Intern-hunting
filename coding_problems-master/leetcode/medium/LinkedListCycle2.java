/**
 * Problem: Find the node where the cycle begins
 *
 * Solution: fast/slow runner technique
 */

public class LinkedListCycle2{
	public ListNode detectCycle(ListNode head){
		if(head==null || head.next==null){
			return null;
		}

		ListNode fast = head;
		ListNode slow = head;
        //fast runner is twice faster as slow runner
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			//meet in the cycle
			if(fast == slow){
				break;
			}
		}
		//no cycle
		if(fast != slow){
			return null;
		}

		fast = head;
		//find cycle head
		while(fast != slow){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}