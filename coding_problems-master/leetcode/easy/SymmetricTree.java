/**
 * Problem: Check if a binary tree is a mirror of itself
 *
 * Solution: use a helper function to recursively check if two subtrees are symmetric
 */

public class SymmetricTree{
	public boolean isSymmetric(TreeNode root){
		if(root == null){
			return true;
		}
		return isSymmetricHelper(root.left,root.right);
	}

	//check if two trees are symmetric
	public boolean isSymmetricHelper(TreeNode t1, TreeNode t2){
		if(t1==null && t2==null){
			return true;
		}
		if(t1==null || t2==null){
			return false;
		}
		if(t1.val == t2.val){
			//recursively check on subtrees
			return isSymmetricHelper(t1.left,t2.right) && isSymmetricHelper(t1.right,t2.left);
		}else{
			return false;
		}
	}
}