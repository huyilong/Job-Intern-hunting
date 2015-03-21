/**
 * Problem: Swap adjacent nodes in a singly linkedlist
 *
 * Solution: Use two pointers to adjacent nodes and link two nodes to previous swapped list
 */

public class SwapNodeInPair{
	public ListNode swapPairs(ListNode head){
		if(head==null){
			return null;
		}else if(head.next==null){
			return head;
		}
        //two pointers to adjacent nodes
		ListNode first = head;
		ListNode second = head.next;
		head = second;
		//previous tail
		ListNode prevTail = first;
		boolean firstTime = true;
		while(first!=null && second!=null){
			//swap nodes
			first.next = second.next;
			second.next = first;
			if(firstTime){
				firstTime = false;
			}else{
				//link swapped nodes to previous list
				prevTail.next = second;
			}
			//update pointers
			prevTail = first;
			first = first.next;
			if(first != null){
			  second = first.next;
			}
		}
		return head;
	}
}