//remove duplicates and keep only distinct nodes

//sol: 

public class RemoveDuplicatesSortedList2{
	public ListNode deleteDuplicates(ListNode head){
		if(head==null || head.next==null){
			return head;
		}
		ListNode iter = head;
		int freq = 1;
		ListNode resHead = null;
		ListNode resCurr = null;

		while(iter != null){
			//escape duplicates
			while(iter!=null && iter.val == iter.next.val){
				iter = iter.next;
				freq ++;
			}
			//check if distinct
			if(freq == 1){
				if(resHead == null){
					resHead = iter;
					resCurr = resHead;
				}else{
					resCurr.next = iter;
					resCurr = iter;
				}
			}
			//reset and move on
			freq = 1;
			iter = iter.next;
		}
		//avoid case like 1->2->2
		if(resCurr != null){
			resCurr.next = null;
		}
		return resHead;
	}
}