/**
 * Problem: Binary Tree Inorder traversal iteratively
 *
 * Solution: Use a stack to store parent nodes. Traverse to the left until reaching a leaf, then pop parent node from stack
 *           and switch to parent's right subtree.
 */

import java.util.*;
public class BinaryTreeInorder{
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> inorder = new LinkedList<Integer>();
		if(root == null){
			return inorder;
		}
		Stack<TreeNode> parent = new Stack<TreeNode>();
		TreeNode curr = root;
		while(!parent.isEmpty() || curr!=null){
			//store parent node and visit left subtree
			if(curr != null){
				parent.push(curr);
				curr = curr.left;
			}else{
				//visit parent
				curr = parent.pop();
				inorder.add(curr.val);
				//go to right subtree
				curr = curr.right;
			}
		}
		return inorder;
	}
}