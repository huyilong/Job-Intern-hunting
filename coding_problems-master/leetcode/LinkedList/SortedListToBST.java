//convert sorted linkedlist to height balanced BST

//sol1: build the tree from up to bottom, build root using middle node, and recursively
//call the method to build left/right subtrees

//sol2: build the tree from bottom up

public class SortedListToBST{
	public TreeNode sortedListToBST(ListNode head){
		if(head==null){
			return null;
		}else if(head.next==null){
			return new TreeNode(head.val);
		}
		ListNode midLeft = getMidLeft(head);
		ListNode mid = midLeft.next;
		TreeNode root = new TreeNode(mid.val);
		midLeft.next = null;
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(mid.next);
		return root;
	}

	public ListNode getMidLeft(ListNode head){
		if(head==null || head.next==null){
			return head;
		}
		ListNode runner = head.next.next;
		ListNode walker = head;
		while(runner!=null && runner.next!=null){
			runner = runner.next.next;
			walker = walker.next;
		}
		return walker;
	}
    
    static ListNode curr = null;
	public TreeNode sortedListToBST(ListNode head){
		if(head==null){
			return null;
		}else if(head.next==null){
			return new TreeNode(head.val);
		}
		int len = 0;
		ListNode iter = head;
		curr = head;
		while(iter!=null){
			len++;
			iter = iter.next;
		}
		return build(1,len);
	}

	public TreeNode build(int left, int right){
		if(left>right){
			return null;
		}
		int mid = left + (right-left)/2;
		TreeNode leftTree = build(left,mid-1);
		TreeNode root = new TreeNode(curr.val);
		root.left = leftTree;
		curr = curr.next;
		root.right = build(mid+1,right);
		return root;
	}


}