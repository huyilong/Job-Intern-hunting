/**
 * Problem: Sort linkedlist in O(nlgn) time and constant space
 *
 * Solution: Use merge sort--sort left and right half list and then merge two sorted lists using two pointers.
 *           Note that merge sort approach uses recursion, which results in O(lgn) stack space.
 */

public class SortList{
	public ListNode sortList(ListNode head){
		if(head == null || head.next==null){
			return head;
		}
		//find middle node
		ListNode mid = middle(head);
		//sort right half list
		ListNode right = sortList(mid.next);
		mid.next = null;
		//sort left half list
		ListNode left = sortList(head);
        //merge sorted half lists
		return merge(left,right);
	}
    
    //use fast/slow runner to find middle element
	public ListNode middle(ListNode head){
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	//merge two sorted list using two pointers
	public ListNode merge(ListNode left, ListNode right){
		if(left==null && right==null){
			return null;
		}else if(left==null){
			return right;
		}else if(right==null){
			return left;
		}

		ListNode dummy = new ListNode(0);
		ListNode iter = dummy;
		//part with same length
		while(left!=null && right!=null){
			if(left.val < right.val){
				iter.next = left;
				left = left.next;
			}else{
				iter.next = right;
				right = right.next;
			}
			iter = iter.next;
		}
		//deal with left over
		if(left!=null){
			iter.next = left;
		}else{
			iter.next = right;
		}
		return dummy.next;
	}

}