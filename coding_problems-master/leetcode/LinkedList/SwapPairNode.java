//swap adjacent pair nodes

//sol: two pointers, one points to the node before current pair, another points to 
//the first node in the pair; swap continues if two nodes in current pair are not null
public class SwapPairNode{
	public ListNode swapPairs(ListNode head){
		if(head==null || head.next==null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		//previous node before a pair
		ListNode pairHead = dummy;
		//first node in pair
		ListNode pair = dummy.next;
        //continue if both nodes in the pair are not null
		while(pair!=null && pair.next!=null){
			//store first node in next pair
			ListNode temp = pair.next.next;
			//swap nodes in current pair
			pair.next.next = pairHead.next;
			pairHead.next = pair.next;
			pair.next = temp;
			//prepare for next pair
			pairHead = pair;
			pair = pairHead.next;
		}
		return dummy.next;
	}
}