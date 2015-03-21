/**
 * Problem: Sum up all root-to-leaf paths
 *
 * Solution: Use DFS to sum bottom up. 
 */

public class SumRootToLeaf{
	public int sumNumbers(TreeNode root){
		return sumHelper(root,0);
	}

	public int sumHelper(TreeNode root, int prevSum){
		if(root == null){
			return 0;
		}
		int sum = prevSum*10 + root.val;

		//reach a leaf and return sum
		if(root.left==null && root.right==null){
			return sum;
		}
		//branch deeper
		return sumHelper(root.left,sum) + sumHelper(root.right, sum);
	}
}