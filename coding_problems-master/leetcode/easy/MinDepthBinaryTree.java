/**
 * Problem: Find min depth of a binary tree
 *
 * Solution 1 and 2: if node is a leaf, depth is 1; if a node has an empty subtree and a non-empty subtree, compute depth of non-empty one
 *           (to do this, we can (a)return MAX_VALUE for the empty one (b)use control flow)
 *
 * Solution 3: Breadth First Search(return depth when reach a leaf), works well if tree is unbalanced
 */

import java.util.*;
public class MinDepthBinaryTree{
	public int minDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		return minDepthHelper(root);
	}

	public int minDepthHelper(TreeNode root){
		//if a child is null, assign max_value to ignore it
		if(root == null){
			return Integer.MAX_VALUE;
		}
		//leaf
		if(root.left==null && root.right==null){
			return 1;
		}
		return 1+Math.min(minDepthHelper(root.left),minDepthHelper(root.right));
	}

	public int minDepth2(TreeNode root){
		if(root == null){
			return 0;
		}
		//left subtree is empty
		if(root.left == null){
			return 1+minDepth2(root.right);
		}
		//right subtree is empty
		if(root.right == null){
			return 1+minDepth2(root.left);
		}
		//non-empty subtrees
		return 1+Math.min(minDepth2(root.left), minDepth2(root.right));
	}
    
    //BFS
	public int minDepth3(TreeNode root){
		if(root == null){
			return 0;
		}
		int depth = 1;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		//mark the last node to visit at next level
		TreeNode levelEnd = root;
		while(!q.isEmpty()){
			TreeNode curr = q.poll();
			//reach a leaf
			if(curr.left==null && curr.right==null){
				break;
			}
			//add children to queue
			if(curr.left != null){
				q.add(curr.left);
			}
			if(curr.right != null){
				q.add(curr.right);
			}
			if(curr == levelEnd){
				depth ++;
				//update new end flag
				if(curr.right != null){
					levelEnd = curr.right;
				}else{
					levelEnd = curr.left;
				}
			}
		}
		return depth;
	}
}