/**
 * Problem: Remove duplicates such that only distinct numbers left
 *
 * Solution:
 */

public class RemoveDuplicateSortedList2{
	public ListNode deleteDuplicates(ListNode head){
		if(head == null){
			return null;
		}else if(head.next == null){
			return head;
		}

		ListNode num = head;
		head = null;
		ListNode curr = null;
		int count = 1;

		while(num != null){
			while(num!=null && num==num.next){
				num = num.next;
				count++;
			}
			if(count < 2){
				if(head == null){
				   head = num;
				   curr = head;
			    }else{
				   curr.next = num;
				   curr = curr.next;
			    }
			}
			num = num.next;
			count = 1;
		}
		return head;
	}
}