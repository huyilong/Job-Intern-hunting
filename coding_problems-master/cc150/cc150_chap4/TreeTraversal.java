/**
 * Tree traversal algorithms:
 *  1) In order traversal
 *  2) Level order traversal
 */

public class TreeTraversal{
	//in-order traversal
	public static String inOrder(TreeNode root){
		if(root == null){
			return "";
		}
		return inOrder(root.left) + " " + root.data + " " + inOrder(root.right);
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