//determine cycle in linked list

//sol: fast/slow runner

public class LinkedListCycle{
	public boolean hasCycle(ListNode head){
		//no node or one node
		if(head==null || head.next==null){
			return false;
		}
		//fast runner is twice faster
		ListNode fast = head;
		ListNode slow = head;

		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			//cycle detected
			if(fast==slow){
				return true;
			}
		}
		return false;
	}
}