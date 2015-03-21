/**
 * Problem: given a sorted array, create a BST with min height
 * Solution: recursively create tree on subarray
 *
 */

public class minHeightTree{
	public static void main(String[] args){
		int[] arr = new int[]{0,1,2,3,4};
		TreeNode root = createTree(arr);
		System.out.println(TreeTraversal.inOrder(root));
	}

	public static TreeNode createTree(int[] arr){
		return createTreeHelper(arr,0,arr.length-1);
	}

	public static TreeNode createTreeHelper(int[] arr, int start, int end){
		if(end < start){
			return null;
		}
		int mid = (start + end)/2;
		//build root
		TreeNode root = new TreeNode(arr[mid]);
		//build left subtree
		root.left = createTreeHelper(arr, start, mid-1);
		//build right subtree
		root.right = createTreeHelper(arr, mid+1, end);
		return root;
	}
}