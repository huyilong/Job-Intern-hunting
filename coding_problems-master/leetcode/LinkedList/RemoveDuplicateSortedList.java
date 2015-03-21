//remove duplicates in the sorted list

//use one pointer to track current value and use another pointer to find the next value

public class RemoveDuplicateSortedList{
	public ListNode deleteDuplicates(ListNode head){
		if(head == null || head.next==null){
            return head;
		}
		ListNode currNum = head;
		ListNode nextNum = head;

		while(nextNum != null){
			while(nextNum!=null && nextNum.val == currNum.val){
				nextNum = nextNum.next;
			}
			currNum.next = nextNum;
			currNum = nextNum;
		}
		return head;
	}
}