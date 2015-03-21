//add two numbers represented by two lists in reverse order

public class AddTwoNumbers{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		if(l1==null && l2==null){
			return null;
		}else if(l1==null){
			return l2;
		}else if(l2==null){
			return l1;
		}

		int val = l1.val + l2.val;
		int carryon = val/10;
		val = val%10;
		ListNode res = new ListNode(val);
		ListNode resIter = res;
		l1 = l1.next;
		l2 = l2.next;
		//add part with common length
		while(l1!=null && l2!=null){
			val = l1.val + l2.val + carryon;
			carryon = val/10;
			val = val%10;
			resIter.next = new ListNode(val);
			resIter = resIter.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		//deal with left-over list
		while(l1!=null || l2!=null){
			int nodeval = l1!=null? l1.val:l2.val;
			val = nodeval + carryon;
			carryon = val/10;
			val = val%10;
			resIter.next = new ListNode(val);
			resIter = resIter.next;
			if(l1==null){
				l2 = l2.next;
			}else{
				l1 = l1.next;
			}
		}
		if(carryon == 1){
			resIter.next = new ListNode(carryon);
		}
		return res;
	}
}