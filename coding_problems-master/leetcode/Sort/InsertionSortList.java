//Sort list using insertion Sort

public class InsertionSortList{
	public ListNode insertionSortList(ListNode head){
		if(head==null || head.next==null){
			return head;
		}
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
        
        ListNode key = head;
		ListNode iter = dummy;

		while(key!=null){
			ListNode temp = key.next;
			iter = dummy;
			while(iter.next!=null && iter.next.val<key.val){
				iter = iter.next;
			}

			key.next = iter.next;
			iter.next = key;
			key = temp;
		}

		return dummy.next;
	}
}