/**
 * Problem: check if a binary tree is balanced
 *           balance: heights of subtrees can never differ by more than one
 * Solution 1: recursively check if left/right subtree is balanced
 * Solution 2: still recursive approach, but return actual height if balanced
 *
 */

public class isBalance{
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[7];
		for(int i=0; i<nodes.length; i++){
			nodes[i] = new TreeNode(i);
		}
		nodes[0].setChild(nodes[1], nodes[2]);
		nodes[1].setChild(nodes[3], nodes[4]);
		//nodes[4].setChild(nodes[5], nodes[6]);
		System.out.println(balance2(nodes[0]));
	}

	public static boolean balance1(TreeNode root){
		if(root == null){
			return true;
		}else{
			return Math.abs(height(root.left)-height(root.right))<=1 && balance1(root.left) && balance1(root.right);
		}
	}

	public static int height(TreeNode n){
		if(n == null){
			return 0;
		}else{
			return 1 + Math.max(height(n.left), height(n.right));
		}
	}

	public static boolean balance2(TreeNode root){
		return balanceHelper(root)!=-1;
	}

	public static int balanceHelper(TreeNode root){
		if(root == null){
			return 0;
		}

		//check if subtrees are balanced
		int leftHeight = balanceHelper(root.left);
		if(leftHeight == -1){
			return -1;
		}
		int rightHeight = balanceHelper(root.right);
		if(rightHeight == -1){
			return -1;
		}

        //check if current tree is balanced
		if(Math.abs(leftHeight - rightHeight) > 1){
			return -1;
		}else{
			//return actual height
			return 1 + Math.max(leftHeight, rightHeight);
		}
 
	}




}