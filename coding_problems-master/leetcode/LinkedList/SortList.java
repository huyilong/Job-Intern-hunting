//sort list in O(nlogn) time and O(1) space

//merge sort

public class SortList{
	public ListNode sortList(ListNode head){
		if(head == null){
			return null;
		}
		return sort(head);
	}

	public ListNode sort(ListNode head){
		if(head==null || head.next==null){
			return head;
		}
		//find middle node
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode temp = slow.next;
		//unlink with right sublist
		slow.next = null;
		//sort sublists and then merge
		return merge(sort(head),sort(temp))
	}
    
    //merge two sorted lists
	public ListNode merge(ListNode l1, ListNode l2){
		if(l1==null && l2==null){
			return null;
		}else if(l1==null){
			return l2;
		}else if(l2==null){
			return l1;
		}
		//dummy head
		ListNode res = new ListNode(0);
		ListNode resCurr = res;
		//part with common length
		while(l1!=null && l2!=null){
			if(l1.val < l2.val){
				resCurr.next = l1;
				l1 = l1.next;
			}else{
				resCurr.next = l2;
				l2 = l2.next;
			}
			resCurr = resCurr.next;
		}
        //left-over
		if(l1!=null){
			resCurr.next = l1;
		}
		if(l2!=null){
			resCurr.next = l2;
		}
		return res.next;
	}
}