/**
 * Problem: Binary Tree Post Order Traversal
 *
 * Solution: Use stack to store parent nodes and mark last visiited node. When parent node is not null,
 *           keep branching to the left; Otherwise, if last visit node is coming from left child and right
 *           child is not null, then switch to traverse the right subtree. If not, visit parent.
 */
import java.util.*;
public class BinaryTreePostorder{
	public LinkedList<Integer> postorderTraversal(TreeNode root){
		LinkedList<Integer> visit = new LinkedList<Integer>();
		Stack<TreeNode> parent = new Stack<TreeNode>();
		TreeNode lastVisit = root;

		while(!parent.isEmpty() || root!=null){
			if(root != null){
				parent.push(root);
				root = root.left;
			}else{
				TreeNode peekNode = parent.peek();
				//coming from left subtree and right subtree is not null, then traverse right subtree
				if(peekNode.right!=null && lastVisit!=peekNode.right){
					root = peekNode.right;
				}else{
					visit.add(peekNode.val);
					lastVisit = parent.pop();
				}
			}

		}

		return visit;

	}
}