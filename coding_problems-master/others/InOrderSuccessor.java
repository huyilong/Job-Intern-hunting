//Medallia
//find in-order successor of given node
//if right subtree of node is not NULL, in-order successor is min node in right subtree
//if right subtree is NULL, search from the root, travel down the tree, if node's val is
//greater than root's value, then go right, otherwise go left
//time O(h)

//if we have links to parent nodes, see https://github.com/startupjing/coding_problems/blob/master/cc150/cc150_chap4/inOrderSuccessor.java


public class InOrderSuccessor{
	public static void main(String[] args){

	}

	public static TreeNode inOrderSuccessor(TreeNode root, TreeNode n){
		if(root==null || n==null){
			return null;
		}
		if(n.right != null){
			return minNode(n.right);
		}
		TreeNode res = null;
		while(root != null){
			if(n.data < root.data){
				res = root;
				root = root.left;
			}else if(n.data > root.data){
				root = root.right;
			}else{
				break;
			}
		}
		return res;
	}



	public static TreeNode minNode(TreeNode root){
		TreeNode curr = root;
		while(curr.left != null){
			curr = curr.left;
		}
		return curr;
	}
}