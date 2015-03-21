/**
 * Problem: Convert sorted array to height balanced BST
 *
 * Solution: Build root using middle element, and build left/right child using recursion on left/right subarrays
 */

public class SortedArrayToBinaryTree{
	public TreeNode sortedArrayToBST(int[] num){
		if(num==null || num.length==0){
			return null;
		}
		return helper(num,0,num.length-1);
	}

	public TreeNode helper(int[] num, int low, int high){
		int midIndex = (low+high)/2;
		if(midIndex < low || midIndex > high){
			return null;
		}
		TreeNode root = new TreeNode(num[midIndex]);
		root.left = helper(num,low,midIndex-1);
		root.right = helper(num,midIndex+1,high);
		return root;
	}
}