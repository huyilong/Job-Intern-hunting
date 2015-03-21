/**
 * Problem: Rotate the list to the right by k places
 *
 * Solution:
 */

public class RotateList{
	public ListNode rotateRight(ListNode head, int n){
		if(head==null || n<=0){
			return head;
		}

		ListNode runner = head;
		//move runner pointer ahead
		while(runner!=null && n>0){
			runner = runner.next;
			n --;
		}
		// n is the length of list
		if(runner == null){
			return head;
		}
		ListNode nlast = head;
		//find (n+1)th last element
		while(runner.next != null){
			runner = runner.next;
			nlast = nlast.next;
		}
		//break into two lists
		ListNode newHead = nlast.next;
		nlast.next = null;
		//put second list before first list
		runner.next = head;
		return newHead;
	}
}