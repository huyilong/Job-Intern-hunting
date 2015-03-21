/**
 * Problem: add two numbers represented as lists
 *
 * Solution: Two pointers
 */

public class AddTwoNumbers{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		//immediate case
		if(l1==null && l2==null){
			return null;
		}else if(l1 == null){
			return l2;
		}else if(l2 == null){
			return l1;
		}
		
		ListNode sumHead = null;
		ListNode sumIter = null;
		int val = 0;
		int carry = 0;
        //add part with same length
		while(l1!=null && l2!=null){
			val = l1.val + l2.val + carry;
			carry = val/10;
			val = val%10;
			//first node to insert
			if(sumHead == null){
				sumHead = new ListNode(val);
				sumIter = sumHead;
			}else{
				sumIter.next = new ListNode(val);
				sumIter = sumIter.next;
			}
			l1 = l1.next;
			l2 = l2.next;
		}

		//add rest of l1 if needed
		while(l1!=null){
			val = l1.val + carry;
			carry = val/10;
			val = val%10;
			sumIter.next = new ListNode(val);
		    sumIter = sumIter.next;
		    l1 = l1.next;
		}

		//add rest of l2 if needed
		while(l2!=null){
			val = l2.val + carry;
			carry = val/10;
			val = val%10;
			sumIter.next = new ListNode(val);
		    sumIter = sumIter.next;
		    l2 = l2.next;
		}

		//add additional node if carry on
		if(carry == 1){
			sumIter.next = new ListNode(carry);
		}
		return sumHead;
	}
}