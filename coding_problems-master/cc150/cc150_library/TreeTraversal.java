/**
 * Tree traversal algorithms:
 *  1) In-order traversal
 *  1) Pre-order traversal
 *  1) Post-order traversal
 *  2) Level order traversal
 */

public class TreeTraversal{
	//in-order traversal
	public static String inOrder(TreeNode root){
		if(root == null){
			return "x";
		}
		return inOrder(root.left) + " " + root.data + " " + inOrder(root.right);
	}

	//pre-order traversal
	public static String preOrder(TreeNode root){
		if(root == null){
			return "x";
		}
		return root.data + " " + preOrder(root.left) + " " + preOrder(root.right);
	}

	//post-order traversal
	public static String postOrder(TreeNode root){
		if(root == null){
			return "x";
		}
		return postOrder(root.left) + " " + postOrder(root.right) + " " + root.data;
	}

    //level order traversal
	public static String levelOrder(TreeNode root){
		if(root == null){
			return null;
		}
		StringBuffer buf = new StringBuffer();
		Queue q = new Queue();
		q.enqueue(root);
		while(!q.isEmpty()){
			TreeNode curr = (TreeNode)q.dequeue();
			buf.append(curr.data + " ");
			if(curr.left != null){
				q.enqueue(curr.left);
			}
			if(curr.right != null){
				q.enqueue(curr.right);
			}
		}
		return buf.toString();
	}


}