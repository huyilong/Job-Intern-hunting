/**
 * Problem: Implement an iterator over BST
 *
 * Solution: Use a stack to store trace
 */

public class BSTIterator{
	private TreeNode iter;
	private Stack<TreeNode> trace;

	public BSTIterator(TreeNode root){
		iter = root;
		trace = new Stack<TreeNode>();
	}

	public boolean hasNext(){
		return(!trace.isEmpty() || iter!=null);
	}

	public int next(){
		while(iter!=null){
			trace.push(iter);
			iter = iter.left;
		}
		TreeNode n = trace.pop();
		iter = n.right;
		return n.val;
	}
}