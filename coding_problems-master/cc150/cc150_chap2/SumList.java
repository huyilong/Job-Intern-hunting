/**
 * Problem: sum list in reverse order
 *          follow up: sum in order
 *
 * Solution: simple scan and sum two lists
 *           follow: reverse pointer and convert into sum reverse order problem
 */
public class SumList{
	public static void main(String[] args){
		SinglyList l1 = new SinglyList(new int[]{7,1,6});
		SinglyList l2 = new SinglyList(new int[]{5,9,2,1});
		System.out.println(l1.print());
		System.out.println(l2.print());
		System.out.println(sumReverse(l1.head, l2.head).printForward());

		SinglyList l3 = new SinglyList(new int[]{6,1,7});
		SinglyList l4 = new SinglyList(new int[]{2,9,5,1});
		System.out.println(l3.print());
		System.out.println(l4.print());
		System.out.println(sumOrder(l3.head, l4.head).printForward());

	}

	public static ListNode sumReverse(ListNode n1, ListNode n2){
		//immediate case
		if(n1 == null){
			return n2;
		}else if(n2 == null){
			return n1;
		}
        
        //compute first node
        int data = n1.data + n2.data;
        int carryon = data / 10;
        data = data % 10;
        ListNode sumHead = new ListNode(data, null, null);
        ListNode sumCurr = sumHead;

		ListNode curr1 = n1.next;
		ListNode curr2 = n2.next;
	
		while(curr1!=null && curr2!=null){
			//compute sum and carryon bit
			data = curr1.data + curr2.data + carryon;
			carryon = data / 10;
			data = data % 10;
			//insert into result list
			sumCurr.next = new ListNode(data, null, null);
			sumCurr = sumCurr.next;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
        
        //continue if one list if longer than the other
        ListNode temp = null;
		if(curr1 != null){
			temp = curr1;
		}else if(curr2 != null){
			temp = curr2;
		}
        //similar sum procedure
		while(temp != null){
			data = temp.data + carryon;
			carryon = data / 10;
			data = data % 10;
			sumCurr.next = new ListNode(data, null, null);
			sumCurr = sumCurr.next;
			temp = temp.next;
		}

		return sumHead;

	}

	public static ListNode sumOrder(ListNode n1, ListNode n2){
		if(n1 == null){
			return n2;
		}else if(n2 == null){
			return n1;
		}
		return reverse(sumReverse(reverse(n1),reverse(n2)));
	}

    //reverse the list and return new head
	public static ListNode reverse(ListNode n){
		if(n == null){
			return null;
		}
		ListNode temp = n.next;
		//set next pointer of old head to null
		n.next = null;
		ListNode tempNext = null;
		ListNode tempPrev = n;
		while(temp != null){
            tempNext = temp.next;
            temp.next = tempPrev;
            tempPrev = temp;
            temp = tempNext;
            if(tempNext != null){
               tempNext = tempNext.next;
            }
		}
		return tempPrev;
	}
}