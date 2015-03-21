/**
 * TreeNode class for Tree problems
 */

public class TreeNode{
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;

	public TreeNode(int data){
		this.data = data;
	}

	public void setLeft(TreeNode left){
		this.left = left;
		if(left != null){
			this.left.parent = this;
		}
	}

	public void setRight(TreeNode right){
		this.right = right;
		if(right != null){
			this.right.parent = this;
		}
	}

	public void setChild(TreeNode left, TreeNode right){
		setLeft(left);
		setRight(right);
	}
}