//reverse linkedlist in some range in place with one pass

public class ReverseLinkedList2{
	public ListNode reverseBetween(ListNode head, int m, int n){
		if(head==null || m>=n){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int countM = 1;
		int countN = 1;
		ListNode left = dummy;
		ListNode right = head;
		//found left and right boundary
		while(countM<m || countN<n){
			if(countM<m && left!=null){
				left = left.next;
				countM++;
			}
			if(countN<n && right!=null){
				right = right.next;
				countN++;
			}
		}
		//reverse the list between two boundaries
		reverseHelper(left,right.next);
		return dummy.next;
	}
    
    //reverse list between two boundaries
	public void reverseHelper(ListNode left, ListNode right){
		ListNode prev = left.next;
		ListNode curr = left.next.next;
		ListNode tail = left.next;
		while(curr != right){
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		left.next = prev;
		tail.next = curr;
	}

}