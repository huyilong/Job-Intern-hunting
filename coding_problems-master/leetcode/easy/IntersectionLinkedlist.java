/**
 * Problem: Find the intersection of two singly linked lists
 *
 * Solution: count number of nodes of two lists, and start traversing
 *           with same number of nodes left
 * If conditions allowed:
 * Solution 1: use nested loops
 * Solution 2: mark node visited 
 */

public class IntersectionLinkedlist{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if(headA==null || headB==null){
			return null;
		}
		//compute difference in number of nodes
		int diff = countNode(headA) - countNode(headB);
		//adjust starting pointers
		if(diff > 0){
			headA = moveForward(headA, Math.abs(diff));
		}else if(diff < 0){
			headB = moveForward(headB, Math.abs(diff));
		}
		//check if heads are the same after adjusting pointers
		if(headA == headB){
			return headA;
		}
		//move both pointers at same speed
		while(headA!=null && headB!=null){
			//find intersection
			if(headA.next == headB.next){
				return headA.next;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}
    
    //count number of nodes in a list
	public int countNode(ListNode head){
		if(head == null){
			return 0;
		}
		int count = 0;
		while(head != null){
			count ++;
			head = head.next;
		}
		return count;
	}
    
    //move pointer ahead by given steps
	public ListNode moveForward(ListNode head, int step){
		for(int i=0; i<step; i++){
			head = head.next;
		}
		return head;
	}


}