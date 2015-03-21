/**
 * Problem: Remove nth node from the end of singly linked list
 *
 * Solution: two pointers
 */

public class RemoveNodeEnd{
	public ListNode removeNthFromEnd(ListNode head, int n){
		if(head == null){
			return null;
		}else if(head.next == null){
			return null;
		}

		ListNode prev = head;
		ListNode p = head;
		//move pointer forward by n steps
		while(n>0){
			p = p.next;
			n--;
		}
		//node to delete is the head
		if(p == null){
			head = head.next;
			return head;
		}
        //move prev to the node before the node to delete
		while(p.next != null){
			p = p.next;
			prev = prev.next;
		}
        //delete the node
		ListNode nextNode = prev.next;
		if(nextNode != null){
			nextNode = nextNode.next;
		}
		prev.next = nextNode;
		return head;
	}
}