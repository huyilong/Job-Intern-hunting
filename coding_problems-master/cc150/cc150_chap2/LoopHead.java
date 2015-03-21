/**
 * Problem: given circular list, find the head of the loop
 *
 * Solution: slow/fast runner technique
 */
public class LoopHead{
	public static void main(String[] args){
		SinglyList l1 = new SinglyList(new int[]{1,2,3,4,5,3});
		l1.head.next.next.next.next.next = l1.head.next.next;
		System.out.println(findHead(l1.head));
	}

	public static int findHead(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		//fast runner is twice faster than slow runner
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast){
				break;
			}
		}
        //no loop detected
		if(fast==null || fast.next==null){
			return -1;
		}

		fast = head;
		//move fast and slow runner at the same speed
		//collision will occur at loop head
		while(fast != slow){
			fast = fast.next;
			slow = slow.next;
		}
		return fast.data;
	}
}