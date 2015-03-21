/**
 * Problem: Determine if the binary tree hash a root-to-leaf path sum
 *
 * Solution: recursively check on left/right subtree with reduced sum
 */

public class PathSum{
	public boolean hasPathSum(TreeNode root, int sum){
		if(root == null){
			return false;
		}
		//root-to-leaf path sum found
		if(root.val==sum && root.left==null && root.right==null){
			return true;
		}
        //continue to check left/right subtree with new sum
		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
	}
}