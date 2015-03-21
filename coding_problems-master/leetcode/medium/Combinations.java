/**
 * Problem: Generate all possible combinations of k numbers out of 1..n
 *
 * Solution: Similar to permutation, but only limit list size to k
 */

import java.util.*;
public class Combinations{
	public ArrayList<ArrayList<Integer>> combine(int n, int k){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(n < k){
			return result;
		}
		ArrayList<Integer> comb = new ArrayList<Integer>();
		combineHelper(result,comb,n,k,1);
		return result;
	}

	public void combineHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> comb,
		                                   int n, int k, int front){
		//limit list size to k
		if(comb.size() == k){
			result.add(new ArrayList<Integer>(comb));
			return;
		}

		//start from index front
		for(int i=front; i<=n; i++){
			//add origin
			comb.add(i);
			//generate combinations starting at i
			combineHelper(result,comb,n,k,front+1);
			//remove origin to try next one
			comb.remove(comb.size()-1);
		}
	}
}