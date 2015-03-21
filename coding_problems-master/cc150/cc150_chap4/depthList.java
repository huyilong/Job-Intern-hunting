import java.util.*;
/**
 * Problem: given a binary tree, create linkedlists of nodes at each depth
 * Solution 1: BFS, for each level, find all of its children
 * Solution 2: modification of pre-order traversal
 *
 */

public class depthList{
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[8];
		for(int i=0; i<nodes.length; i++){
			nodes[i] = new TreeNode(i);
		}
		nodes[2].setChild(nodes[1],nodes[3]);
		nodes[1].setChild(nodes[4],nodes[5]);
	    nodes[5].setChild(nodes[6], nodes[7]);
	    ArrayList<LinkedList<TreeNode>> result = depList1(nodes[2]);
	    int levelNum = 0;
	    for(LinkedList<TreeNode> level: result){
	    	System.out.print("level " + levelNum + ": ");
	    	for(TreeNode n: level){
	    		System.out.print(n.data + " ");
	    	}
	    	System.out.println();
	    }
    }
    
    //generate list for each level
	public static ArrayList<LinkedList<TreeNode>> depList1(TreeNode root){
		if(root == null){
			return null;
		}
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
		curr.add(root);
		while(curr.size() != 0){
			result.add(curr);
			curr = children(curr);
		}
		return result;
	}
    
    //generate list of children for previous level
	public static LinkedList<TreeNode> children (LinkedList<TreeNode> curr){
		LinkedList<TreeNode> child = new LinkedList<TreeNode>();
		//for each node in previous, add children to the list
		for(TreeNode parent: curr){
			if(parent.left != null){
				child.add(parent.left);
			}
			if(parent.right != null){
				child.add(parent.right);
			}
		}
		return child;
	}

	public static ArrayList<LinkedList<TreeNode>> depList2(TreeNode root){
		if(root == null){
			return null;
		}
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		nextLevel(root, result, 0);
		return result;
	}

	public static void nextLevel(TreeNode root, ArrayList<LinkedList<TreeNode>> result, int level){
		if(root == null){
			return;
		}
		LinkedList<TreeNode> levelNodes = null;
		//level list not in the result list
		if(result.size() == level){
			levelNodes = new LinkedList<TreeNode>();
			result.add(levelNodes);
		}else{
			levelNodes = result.get(level);
		}
		//add node to level list
		levelNodes.add(root);
		//add children to next level list
		nextLevel(root.left, result, level+1);
		nextLevel(root.right, result, level+1);
	}


}