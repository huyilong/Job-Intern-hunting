/**
 * Problem: Find the number of unique BSTs that store values 1..n
 *
 * Solution: tree[i] = #trees given value i
 *           then tree[i] = (#left tree)*(#right tree) for each possible root j = 1,2,...,i
 */

public class UniqueBinarySearchTrees{
	public int numTrees(int n){
		if(n<0){
			return 0; 
		}else if(n==0){
			return 1;
		}

		//trees[i] = number of BSTs given value i
		int[] trees = new int[n+1];
		trees[0] = 1;
		trees[1] = 1;

		for(int i=2; i<=n; i++){
			//compute number of trees if root is j
			for(int j=0; j<=i-1; j++){
				//#trees = #left subtrees * #right subtrees
				trees[i] += trees[j]*trees[i-1-j];
			}
		}
		return trees[n];
	}
}