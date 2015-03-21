/**
 * Problem: Binary Tree preorder traversal
 *
 * Solution: Use a stack to store roots. Visit root first, then store root of right subtree into stack,
 *           switch to visit left subtree until reaching a leaf, then pop right subtree from stack and visit
 */

import java.util.*;
public class BinaryTreePreorder{
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> preorder = new LinkedList<Integer>();
		if(root == null){
			return preorder;
		}
		Stack<TreeNode> parent = new Stack<TreeNode>();
		TreeNode curr = root;
		while(!parent.isEmpty() || curr!=null){
			if(curr != null){
				//visit parent
				preorder.add(curr.val);
				//store root of right subtree to visit after left subtree
				if(curr.right != null){
					parent.push(curr.right);
				}
				//go to left subtree
				curr = curr.left;
			}else{
				//visit right subtree
				curr = parent.pop();
			}
		}
		return preorder;
	}
}