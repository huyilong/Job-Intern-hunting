/**
 * Problem: Find all possible permutations given a collection of numbers
 *
 * Solution: Add a origin not in the list, use recursion to generate all possible permutations starting at origin,
 *           then remove origin to try next element as origin. Once list size is equal to array length,
 *           we know we get a permutation.
 */

import java.util.*;
public class Permutations{
	public ArrayList<ArrayList<Integer>> permute(int[] num){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num==null || num.length==0){
			return result;
		}
		//list to store permutation
		ArrayList<Integer> comb = new ArrayList<Integer>();
		permuteHelper(result,comb,num);
        return result;
	}

	public void permuteHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> comb, int[] num){
		//complete a permutation
		if(comb.size() == num.length){
			ArrayList<Integer> copy = new ArrayList<Integer>(comb);
			result.add(copy);
			return;
		}
		int len = num.length;
		for(int i=0; i<len; i++){
			//no need to add to list
			if(comb.contains(num[i])){
				continue;
			}
			//add a origin
			comb.add(num[i]);
            //generate all permutations
			permuteHelper(result,comb,num);
			//remove origin and try next one
			comb.remove(comb.size()-1);
		}
	}
}