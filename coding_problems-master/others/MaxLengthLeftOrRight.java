//iCIMS
//find the max length of a descending path in a tree which always goes left or right


public class MaxLengthLeftOrRight{
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(15);
		TreeNode n3 = new TreeNode(10);
		TreeNode n4 = new TreeNode(6);
		TreeNode n5 = new TreeNode(14);
		root.left = n1; root.right = n2;
		n2.left = n3;
		n3.left = n4; n3.right = n5;
		System.out.println(calculate(root).maxLength);

	}

	public static Result calculate(TreeNode root){
		if(root == null){
			return new Result(0,0,0);
		}
		Result left = calculate(root.left);
		Result right = calculate(root.right);
		int leftMax = 1 + left.leftMax;
		int rightMax = 1 + right.rightMax;
		int maxLength = Math.max(Math.max(leftMax,rightMax), Math.max(left.maxLength,right.maxLength));
		return new Result(leftMax,rightMax,maxLength);
	}


}

class Result{
	int leftMax;
	int rightMax;
	int maxLength;

	public Result(int leftMax, int rightMax, int maxLength){
		this.leftMax = leftMax;
		this.rightMax = rightMax;
		this.maxLength = maxLength;
	}
}