/**
 * Problem: find in-order successor of a given node in a BST
 *          assuming each node has a link to its parent
 *
 * Solution: three important cases to consider
 *           1) if node has right subtree, then return leftmost child of right subtree
 *           2) if node does not have right subtree, then
 *              a) if node is its parent's left child, then return parent node
 *              b) if node is right child, then return untraversed ancestor node
 */

public class inOrderSuccessor{
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[7];
		for(int i=0; i<nodes.length; i++){
			nodes[i] = new TreeNode(i);
		}
		nodes[0].setChild(nodes[1],nodes[2]);
		nodes[1].setChild(nodes[3],nodes[4]);
		nodes[4].setChild(nodes[5],nodes[6]);
		System.out.println(nextNode(nodes[6]).data);
	}

	public static TreeNode nextNode(TreeNode n){
		//node has right subtree or node is the root
		if(n.right!=null || n.parent==null){
			return leftmost(n.right);
		}else{
			//two pointers to parent and grandparent
			TreeNode currParent = n;
			TreeNode grandParent = currParent.parent;
			//while not left child, keep moving up along the tree
			while(grandParent!=null && grandParent.right==currParent){
				currParent = grandParent;
				grandParent = currParent.parent;
			}
			return grandParent;
		}
	}
    
    //return leftmost child of the tree
	public static TreeNode leftmost(TreeNode n){
		if(n == null){
			return null;
		}
		while(n.left != null){
			n = n.left;
		}
		return n;
	}


}