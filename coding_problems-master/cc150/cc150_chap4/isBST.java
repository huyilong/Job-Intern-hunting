/**
 * Problem: check if a binary tree is a BST
 *
 * Solution 1: in-order traversal, next element must be larger than current element
 * Solution 2: recursive check on allowed range
 */

public class isBST{
	public static int curr = Integer.MIN_VALUE;
	public static int min = Integer.MIN_VALUE;
	public static int max = Integer.MAX_VALUE;

	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[5];
		for(int i=0; i<nodes.length; i++){
			nodes[i] = new TreeNode(i);
		}
		nodes[2].setChild(nodes[1],nodes[3]);
		nodes[1].setChild(nodes[0],null);
	    nodes[3].setChild(null, nodes[4]);
	    System.out.println(TreeTraversal.inOrder(nodes[2]));
		System.out.println(checkBST2(nodes[2]));
	}
    
    //in-order traversal: left-root-right
	public static boolean checkBST1(TreeNode root){
		if(root == null){
			return true;
		}
		//check left subtree
		if(!checkBST1(root.left)){
			return false;
		}
		//check root
		if(root.data < curr){
			return false;
		}else{
			curr = root.data;
		}
		//check right subtree
		if(!checkBST1(root.right)){
			return false;
		}
		return true;
	}

	//recursively check on allowed range
	public static boolean checkBST2(TreeNode root){
		return BSThelper(root, min, max);
	}
   
	public static boolean BSThelper(TreeNode root, int min, int max){
		if(root == null){
			return true;
		}
		//check if root is in the allowed range
		if(root.data > max || root.data < min){
			return false;
		}
		//check left/right subtree
		return BSThelper(root.left, min, root.data) && BSThelper(root.right, root.data, max);
	}
}