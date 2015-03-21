/**
 * Problem: Merge two sorted singly linked lists
 *
 * Solution: two pointers, insert nodes of one list into another
 */

public class MergeSortedList{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		//some immediate cases
		if(l1==null && l2==null){
			return null;
		}else if(l1==null){
			return l2;
		}else if(l2==null){
			return l1;
		}
        //use iter to traverse list
        ListNode head = l1;
        ListNode iter = l1;
        //use addNode to traverse another list and add node
        ListNode addNode = l2;
        //change value if necessary
		if(l1.val > l2.val){
			head = l2;
			iter = l2;
			addNode = l1;
		}
		while(addNode != null){
			//append rest of the list
			if(iter.next == null){
				while(addNode != null){
					ListNode temp = addNode;
					addNode = addNode.next;
					iter.next = temp;
					iter = iter.next;
				}
				return head;
			}
			//insert node between two nodes
			if(addNode.val>=iter.val && addNode.val<=iter.next.val){
				ListNode temp = addNode;
				addNode = addNode.next;
				temp.next = iter.next;
				iter.next = temp;
			}
			iter = iter.next;
		}
		return head;
	}
}