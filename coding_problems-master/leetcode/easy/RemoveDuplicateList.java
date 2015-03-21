/**
 * Problem: Given a sorted list, delete all duplicates 
 *
 * Solution: two pointers, one to traverse different element, another one to pass through duplicates
 */

public class RemoveDuplicateList{
	public ListNode deleteDuplicates(ListNode head){
		if(head == null){
			return null;
		}
		ListNode elem = head;
		ListNode nextElem = head;
		//go through each different element
		while(elem!=null && elem.next != null){
			//go through duplciates
			while(nextElem!=null && nextElem.val==elem.val){
				nextElem = nextElem.next;
			}
			//remove duplicates
			elem.next = nextElem;
			elem = nextElem;
		}
		return head;
	}
}