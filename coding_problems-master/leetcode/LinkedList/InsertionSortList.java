//sort list using insertion sort

//sol: insertion sort
public class InsertionSortList{
	public ListNode insertionSortList(ListNode head){
		if(head==null || head.next==null){
			return head;
		}
		//dummy head
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode curr = head;
		ListNode iter = dummy;
		//go through each node as a card to insert
		while(curr!=null){
			//store next node as temp
			ListNode temp = curr.next;
			iter = dummy;
			//use iter to find position to insert card
			while(iter.next!=null && iter.next.val<curr.val){
				iter = iter.next;
			}
			//insert card
			curr.next = iter.next;
			iter.next = curr;
			//move on to next node
			curr = temp;
		}
		return dummy.next;
	}
}