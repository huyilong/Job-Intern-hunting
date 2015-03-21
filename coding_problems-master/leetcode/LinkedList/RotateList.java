//rotate the list to the right by k places


public class RotateList{
	public ListNode rotateRight(ListNode head, int n){
		if(head == null || n<=0 || head.next==null){
			return head;
		}
		ListNode runner = head;
		ListNode walker = head;
		int count = 0;
		while(count<n && runner!=null){
			runner = runner.next;
			count++;
		}
		//given value n exceeds list length, modolu operation
		if(runner==null){
			n = n%count;
			count = 0;
			runner = head;
			//run again
			while(count<n && runner!=null){
				runner = runner.next;
				count++;
			}
		}
		//move walker and runner at same speed
		//so that walker is at the rotation point in the end
		while(runner.next!=null){
			walker = walker.next;
			runner = runner.next;
		}
		runner.next = head;
		ListNode newHead = walker.next;
		walker.next = null;
		return newHead;
	}
}