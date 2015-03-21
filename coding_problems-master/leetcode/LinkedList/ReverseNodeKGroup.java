//reverse nodes in a list k at a time

public class ReverseNodeKGroup{
	public ListNode reverseKGroup(ListNode head, int k){
		if(head==null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int count = 0;
		ListNode tail = dummy;
		ListNode iter = head;
		while(iter != null){
		    count++;
		    ListNode end = iter.next;
		    if(count == k){
		        tail = reverse(tail,end);
		        count = 0;
		    }
		    iter = end;
		}
		return dummy.next;
	}
	
	public ListNode reverse(ListNode left, ListNode right){
	    if(left==null || left.next==null){
	        return left;
	    }
	    ListNode curr = left.next.next;
	    ListNode tail = left.next;
	    while(curr != right){
	        ListNode temp = curr.next;
	        curr.next = left.next;
	        left.next = curr;
	        curr = temp;
	    }
	    tail.next = curr;
	    return tail;
	}

	
	public ListNode reverseKGroup(ListNode head, int k){
		if(head==null || k<=1 || head.next==null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		reverseHelper(dummy,k);
		return dummy.next;
	}

	public void reverseHelper(ListNode left, int k){
		if(left==null){
			return;
		}
		ListNode right = left;
		//find right boundary
		while(k>0 && right!=null){
			right = right.next;
            k--;
		}
		//not multiple of k, list remains unchanged
		if(k>0){
			return;
		}
		ListNode temp = reverse(left,right.next);
		reverseHelper(temp,k);
	}

	public ListNode reverse(ListNode left, ListNode right){
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
		return tail;
	}
}