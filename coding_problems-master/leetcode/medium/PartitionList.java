/**
 * Problem: Partition the list using given value
 *
 * Solution: Use two lists to store two partitions, traverse the original list and
 *           add nodes to correct list
 */

public class PartitionList{
	public ListNode partition(ListNode head, int x){
		if(head == null){
			return null;
		}
		ListNode smallHead = null;
		ListNode small = null;
		ListNode largeHead = null;
		ListNode large = null;
		ListNode iter = head;

		while(iter != null){
			//clone a node
			ListNode copy = iter;
			iter = iter.next;
			copy.next = null;
            //insert into correct list
			if(copy.val < x){
				if(smallHead == null){
					smallHead = copy;
					small = smallHead;
				}else{
					small.next = copy;
					small = small.next;
				}
			}else{
				if(largeHead == null){
					largeHead = copy;
					large = largeHead;
				}else{
					large.next = copy;
					large = large.next;
				}
			}
		}
        //merge two lists and return head
		if(smallHead != null){
			small.next = largeHead;
			return smallHead;
		}else{
			return largeHead;
		}

	}
}