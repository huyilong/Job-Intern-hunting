/**
 * Problem: Determine if a linked list has a cycle
 *
 * Solution: fast/slow runner technique
 */

public class LinkedListCycle{
	public boolean hasCycle(ListNode head){
		if(head==null || head.next==null){
			return false;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			//two nodes meet
			if(fast!=null && slow!=null && fast.val==slow.val){
				return true;
			}
		}
		return false;
	}
}
