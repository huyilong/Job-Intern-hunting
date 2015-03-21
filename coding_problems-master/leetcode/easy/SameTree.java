/**
 * Problem: Check if two binary trees are equal
 *
 * Solution: recursion
 */

public class SameTree{
	public boolean isSameTree(TreeNode p, TreeNode q){
		if(p==null && q==null){
			return true;
		}
		if(p==null || q==null){
			return false;
		}else{
			return (p.val==q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
		}
	}
}