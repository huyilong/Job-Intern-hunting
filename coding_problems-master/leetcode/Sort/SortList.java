//Sort list in O(nlogn)

public class SortList{
	public ListNode sortList(ListNode head){
		if(head == null || head.next==null){
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
        
        //find middle element
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}

		//unlink to get two separate lists
		ListNode temp = slow.next;
		slow.next = null;

		//merge two sorted lists
		return merge(sortList(head), sortList(temp));
	}

	public ListNode merge(ListNode l1, ListNode l2){
		if(l1==null && l2==null){
			return null;
		}else if(l1 == null){
			return l2;
		}else if(l2 == null){
			return l1;
		}

		ListNode dummy = new ListNode(-1);
		ListNode iter = dummy;

		while(l1!=null && l2!=null){
			if(l1.val < l2.val){
				iter.next = l1;
				l1 = l1.next;
			}else{
				iter.next = l2;
				l2 = l2.next;
			}
			iter = iter.next;
		}

		if(l1 != null){
			iter.next = l1;
		}
		if(l2 != null){
			iter.next = l2;
		}
		return dummy.next;
	}

}