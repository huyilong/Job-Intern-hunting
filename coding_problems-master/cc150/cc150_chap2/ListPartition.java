/**
 * Problem: partition the list by given value k
 *
 * Solution: insert partitioned nodes into two lists
 */
public class ListPartition{
	public static void main(String[] args){
		SinglyList l1 = new SinglyList(new int[]{9,6,1,7,2,0,4,1});
		System.out.println(l1.print());
		System.out.println(partition(l1.head, 3).printForward());

	}

	public static ListNode partition(ListNode head, int k){
		if(head == null){
			return null;
		}
		//create two partition lists
		ListNode smallHead = null;
		ListNode small = null;
		ListNode largeHead = null;
		ListNode large = null;
		ListNode temp = head;
		while(temp != null){
			//copy into a new node and set next pointer to null
			ListNode curr = temp;
			temp = temp.next;
			curr.next = null;

			//put node into small list
			if(curr.data <= k){
				if(smallHead == null){
					smallHead = curr;
				}else{
					small.next = curr;
				}
				small = curr;
			}
			//put node into large list
			else{
				if(largeHead == null){
					largeHead = curr;
				}else{
					large.next = curr;
				}
				large = curr;
			}
		}
        
        //merge two lists
		if(smallHead != null){
			small.next = largeHead;
			return smallHead;
		}else{
			return largeHead;
		}
	}
}