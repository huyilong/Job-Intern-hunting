/**
 * Problem: Given a binary tree with values, print all paths which sum to 
 *          a given value, path can start or end anywhere
 *
 * Solution: use array to store node value at each level, after placing a new value
 *           in the array, check if sum is found. then continue probing on left and
 *           right subtree.
 */

public class pathSum{
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[8];
		for(int i=0; i<nodes.length; i++){
			nodes[i] = new TreeNode(i);
		}
		nodes[0].setChild(nodes[1],nodes[2]);
		nodes[1].setChild(nodes[3],nodes[4]);
		nodes[4].setChild(nodes[5],nodes[6]);
		TreeNode a = new TreeNode(8);
		TreeNode b = new TreeNode(2);
		nodes[2].setChild(a,b);
		sum(nodes[0],10);

	}
    
    //call this method on root
	public static void sum(TreeNode n, int sum){
		if(n == null){
			return;
		}
		int[] path = new int[depth(n)];
		sumHelper(n,sum,path,0);
	}

	public static void sumHelper(TreeNode n, int sum, int[] path, int index){
		if(n == null){
			return;
		}
		path[index] = n.data;
		int k = 0;
		//traverse to see if given sum is reached
		for(int i=index; i>=0; i--){
			k += path[i];
			//print sum 
			if(k == sum){
				printPath(path, i, index);
			}
		}
		//continue probing on left/right subtree
		sumHelper(n.left, sum, path, index+1);
		sumHelper(n.right, sum, path, index+1);

	}
   
    //return depth of a node
	public static int depth(TreeNode n){
		if(n == null){
			return 0;
		}else{
			return 1 + Math.max(depth(n.left), depth(n.right));
		}
	}
    
    //print path sum
	public static void printPath(int[] path, int start, int end){
		for(int i=start; i<end; i++){
			System.out.print(path[i] + "->");
		}
		System.out.println(path[end]);
	}


}