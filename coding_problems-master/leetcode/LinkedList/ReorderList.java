//Reorder list

//sol: divide into two lists of equal length, reverse latter one, and merge together
public class ReorderList{
	public void reorderList(ListNode head){
		if(head==null || head.next==null){
			return;
		}
		ListNode runner = head.next;
		ListNode walker = head;
		//separate into two lists
		while(runner!=null && runner.next!=null){
            runner = runner.next.next;
            walker = walker.next;
		}
		ListNode head2 = walker.next;
		//detach two lists
		walker.next = null;
        

        //reverse second list
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		ListNode curr = head2;
		while(curr!=null){
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		head2.next = null;
		head2 = prev;
        
        //merge two lists
		ListNode iter = head;
		ListNode iterA = head.next;
		ListNode iterB = head2;
		while(iterA!=null && iterB!=null){
			iter.next = iterB;
			iter = iter.next;
			iterB = iterB.next;
			iter.next = iterA;
			iter = iter.next;
			iterA = iterA.next;
		}
		if(iterA!=null){
			iter.next = iterA;
		}
		if(iterB!=null){
			iter.next = iterB;
		}
	}
}