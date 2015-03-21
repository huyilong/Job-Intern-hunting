/**
 * Problem: Generate all combinations of n pairs of parentheses
 *
 * Solution: DFS--invariant is #left<#right, and if #left=n, can only add right parentheses. 
 *           For normal cases, continue to add left parentheses and then add right parentheses
 */
import java.util.*;
public class GenerateParentheses{
	public ArrayList<String> generateParenthesis(int n){
		ArrayList<String> result = new ArrayList<String>();
		generate(result,n,0,0,"");
		return result;
	}

	public void generate(ArrayList<String> result, int n, int left, int right, String s){
		//invariant
		if(left < right){
			return;
		}
		//found a combination
		if(left==right && left==n){
			result.add(s);
			return;
		}

		//left parentheses reach maximum, can only add right parentheses
		if(left == n){
			generate(result,n,left,right+1,s+")");
			return;
		}

		//continue to add left and right parentheses
		generate(result,n,left+1,right,s+"(");
		generate(result,n,left,right+1,s+")");
	}
}