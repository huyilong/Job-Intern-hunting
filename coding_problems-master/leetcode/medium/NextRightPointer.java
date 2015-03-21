/**
 * Problem: Populate next pointer in a tree node to its next right node
 *
 * Solution: First connect two children of the same parent, then connect neighbor children of neighbor parents, 
 *           and finally do recursion on left/right subtrees
 */

public class NextRightPointer{
	public void connect(TreeLinkNode root){
		if(root == null){
			return;
		}
		//link two children of the same parent
		if(root.left != null){
			root.left.next = root.right;
		}
		//link two neighbor children of two different parents
		if(root.right != null){
			if(root.next != null){
				root.right.next = root.next.left;
			}else{
				root.right.next = null;
			}
		}
		//recursion on subtrees
		connect(root.left);
		connect(root.right);
	}
}