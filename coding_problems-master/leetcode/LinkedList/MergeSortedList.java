//merge two sorted list

//merge common part and attach left-over


public class MergeSortedList{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
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