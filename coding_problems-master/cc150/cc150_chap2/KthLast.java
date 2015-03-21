/**
 * Problem: find kth last element in the singly linkedlist
 *
 * Solution: runner technique, one pointer is k-1 steps ahead
 */
public class KthLast{
	public static void main(String[] args){
		SinglyList l1 = new SinglyList(new int[]{1,2,3,4,5});
		System.out.println(l1.print());
		System.out.println(findKLast(l1.head, 1));

	}

	public static int findKLast(ListNode head, int k){
		ListNode front = head;
		ListNode after = head;
		//move pointer k-1 steps ahead
		if(k > 1){
			for(int i=0; i<k-1; i++){
				front = front.next;
				//error check
				if(front==null){
					System.out.println("ERROR: incorrect k value");
					return -1;
				}
			}
		}
        //move two pointers at the same time
		while(front.next != null){
			front = front.next;
			after = after.next;
		}

		return after.data;
	}
}