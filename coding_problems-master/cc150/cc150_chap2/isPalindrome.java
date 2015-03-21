import java.util.*;
/**
 * Problem: check if a linked list is a palindrome
 *
 * Solution 1: reverse and then compare
 * Solution 2: use stack 
 */

public class isPalindrome{
	public static void main(String[] args){
		SinglyList l1 = new SinglyList(new int[]{0,1,2,1,0});
		System.out.println(l1.print());
		System.out.println(palindrome2(l1.head));

	}

    //reverse and then compare
	public static boolean palindrome1(ListNode n){
		if(n == null){
			return true;
		}
		ListNode rev = reverseList(n.cloneForward());
		ListNode revCurr = rev;
		ListNode curr = n;
		while(curr != null){
			if(curr.data != revCurr.data){
				return false;
			}
			curr = curr.next;
			revCurr = revCurr.next;
		}
		return true;
	}

	 //reverse the list and return new head
	public static ListNode reverseList(ListNode n){
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
    

    //use stack
	public static boolean palindrome2(ListNode n){
		if(n == null || n.next==null){
			return true;
		}
		Stack<Integer> s = new Stack<Integer>();
		ListNode mid = n;
		ListNode runner = n;
		//runner is twice faster than mid
		while(runner!=null && runner.next!=null){
			s.push(mid.data);
			mid = mid.next;
			runner = runner.next.next;
		}
		//move mid pointer forward if odd length
		if(runner.next == null){
		   mid = mid.next;
		}
        //pop from stack and compare with list
		while(mid != null){
			if(mid.data != s.pop()){
				return false;
			}
			mid = mid.next;
		}
		return true;
	}

}