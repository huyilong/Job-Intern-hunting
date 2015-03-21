/**
 * Problem: determine if a binary tree is a subtree of another
 * Solution 1: if tree2's preorder and inorder traversal is a substring of tree1's 
 *             preoder and inorder traversal, then tree2 is a subtree
 * Solution 2: branch the large tree, if a node is equal to the root of small tree,
 *             check if the node has the small tree as subtree
 *
 */
public class isSubtree{
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[8];
		for(int i=0; i<nodes.length; i++){
			nodes[i] = new TreeNode(i);
		}
		nodes[0].setChild(nodes[1],nodes[2]);
		nodes[1].setChild(nodes[3],nodes[4]);
		nodes[4].setChild(nodes[5],nodes[6]);

		TreeNode[] test = new TreeNode[3];
		for(int i=0; i<test.length-1; i++){
			test[i] = new TreeNode(i+4);
		}
		test[2] = new TreeNode(7);
		test[0].setChild(test[1],test[2]);
       
		System.out.println(subtree2(nodes[0],nodes[4]));
	}
    
    //use tree traversal
	public static boolean subtree1(TreeNode t, TreeNode n){
		String t_inorder = TreeTraversal.inOrder(t);
		String n_inorder = TreeTraversal.inOrder(n);
		String t_preorder = TreeTraversal.preOrder(t);
		String n_preorder = TreeTraversal.preOrder(n);
		return isSubstring(t_inorder,n_inorder) && isSubstring(t_preorder,n_preorder);
	}
    
    //check if pattern is substring of s
	public static boolean isSubstring(String s, String pattern){
		if(s == null || pattern == null){
			return false;
		}
		return s.indexOf(pattern)>0;
	}

	//keep branching and checking
	public static boolean subtree2(TreeNode t, TreeNode n){
		//empty tree is always a subtree
		if(n == null){
			return true;
		}
		return subtreeHelper(t,n);
	}

	public static boolean subtreeHelper(TreeNode t, TreeNode n){
		if(t == null){
			return false;
		}
		//if two roots are same, check subtree
		if(t.data == n.data){
			return match(t,n);
		}
		//continue branching and checking on subtree if roots do not match
		else{
			return subtreeHelper(t.left,n) || subtreeHelper(t.right,n);
		}
	}
    
    //check if two trees are the same
	public static boolean match(TreeNode t, TreeNode n){
		if(t==null && n==null){
			return true;
		}
		if(t==null || n==null){
			return false;
		}
		//return false if root doesn't match
		if(t.data != n.data){
			return false;
		}
		//check on left and right subtree
		else{
			return match(t.left,n.left) && match(t.right,n.right);
		}

	}


}